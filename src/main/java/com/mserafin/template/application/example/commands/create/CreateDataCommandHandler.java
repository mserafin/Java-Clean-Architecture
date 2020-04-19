package com.mserafin.template.application.example.commands.create;

import java.util.Optional;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.domain.example.ExampleRepository;
import com.mserafin.template.infrastructure.cqrs.EventPublisher;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.CommandHandler;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class CreateDataCommandHandler implements CommandHandler<CreateDataCommand, Long>
{
    private final ServiceLocator dependency;

    public <T extends ServiceLocator> CreateDataCommandHandler(final T dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public Long handle(final CreateDataCommand command)
    {
        final Optional<ExampleRepository> repository = this.dependency.resolve(ExampleRepository.class);
        repository.get().create(command.getData());

        final Optional<EventPublisher> publisher = this.dependency.resolve(EventPublisher.class);
        final Example model = publisher.get().mergeClass(command.getData());

        model.notifyEvent(command);

        return model.id;
    }
}
