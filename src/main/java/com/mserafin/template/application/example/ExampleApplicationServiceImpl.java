package com.mserafin.template.application.example;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mserafin.template.application.example.commands.create.CreateDataCommand;
import com.mserafin.template.application.example.commands.create.CreateDataCommandHandler;
import com.mserafin.template.application.example.commands.delete.DeleteDataCommand;
import com.mserafin.template.application.example.commands.delete.DeleteDataCommandHandler;
import com.mserafin.template.application.example.commands.delete.DeleteDataCommandListener;
import com.mserafin.template.application.example.commands.update.UpdateDataCommand;
import com.mserafin.template.application.example.commands.update.UpdateDataCommandHandler;
import com.mserafin.template.application.example.queries.list.ListDataQuery;
import com.mserafin.template.application.example.queries.list.ListDataQueryHandler;
import com.mserafin.template.application.example.queries.select.SelectDataQuery;
import com.mserafin.template.application.example.queries.select.SelectDataQueryHandler;
import com.mserafin.template.domain.example.Example;
import com.mserafin.template.domain.example.ExampleRepository;
import com.mserafin.template.infrastructure.cqrs.CommandBusImpl;
import com.mserafin.template.infrastructure.cqrs.EventBusImpl;
import com.mserafin.template.infrastructure.cqrs.EventPublisher;
import com.mserafin.template.infrastructure.cqrs.QueryBusImpl;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.CommandBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.QueryBus;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocatorImpl;


@Service
public class ExampleApplicationServiceImpl implements ExampleApplicationService
{
    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleApplicationServiceImpl(final ExampleRepository exampleRepository)
    {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public List<Example> getAll()
    {
        try (final ServiceLocator queryDependency = new ServiceLocatorImpl())
        {
            queryDependency.register(ExampleRepository.class, () -> exampleRepository);
            queryDependency.register(ListDataQuery.class, () -> new ListDataQueryHandler(queryDependency));

            final QueryBus queryBus = new QueryBusImpl(queryDependency);
            return queryBus.process(new ListDataQuery());
        }
        catch (final Exception e)
        {
            return Collections.emptyList();
        }
    }

    @Override
    public Example getById(final Long exampleId)
    {
        try (final ServiceLocator queryDependency = new ServiceLocatorImpl())
        {
            queryDependency.register(ExampleRepository.class, () -> exampleRepository);
            queryDependency.register(SelectDataQuery.class, () -> new SelectDataQueryHandler(queryDependency));

            final QueryBus queryBus = new QueryBusImpl(queryDependency);
            return queryBus.process(new SelectDataQuery(exampleId));
        }
        catch (final Exception e)
        {
            return null;
        }
    }

    @Override
    public Example create(final Example example)
    {
        try (final ServiceLocator commandDependency = new ServiceLocatorImpl())
        {
            commandDependency.register(ExampleRepository.class, () -> exampleRepository);
            commandDependency.register(EventPublisher.class, () -> new EventPublisher());
            commandDependency.register(CreateDataCommand.class, () -> new CreateDataCommandHandler(commandDependency));

            final CommandBus makeCommandBus = new CommandBusImpl(commandDependency);

            final Long id = makeCommandBus.sendCommand(new CreateDataCommand(example));
            return getById(id);
        }
        catch (final Exception e)
        {
            return null;
        }
    }

    @Override
    public Example update(final Example example)
    {
        try (final ServiceLocator commandDependency = new ServiceLocatorImpl())
        {
            commandDependency.register(ExampleRepository.class, () -> exampleRepository);
            commandDependency.register(EventPublisher.class, () -> new EventPublisher());
            commandDependency.register(UpdateDataCommand.class, () -> new UpdateDataCommandHandler(commandDependency));

            final CommandBus makeCommandBus = new CommandBusImpl(commandDependency);

            final Example result = makeCommandBus.sendCommand(new UpdateDataCommand(example));
            return getById(result.id);
        }
        catch (final Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean remove(final Long exampleId)
    {
        try (final ServiceLocator commandDependency = new ServiceLocatorImpl())
        {
            final EventBus eventBus = new EventBusImpl();
            eventBus.publish(new DeleteDataCommandListener());

            commandDependency.register(ExampleRepository.class, () -> exampleRepository);
            commandDependency.register(EventBus.class, () -> eventBus);
            commandDependency.register(DeleteDataCommand.class, () -> new DeleteDataCommandHandler(commandDependency));

            final CommandBusImpl makeCommandBusImpl = new CommandBusImpl(commandDependency);

            return makeCommandBusImpl.sendCommand(new DeleteDataCommand(exampleId));
        }
        catch (final Exception e)
        {
            return false;
        }
    }
}