package com.mserafin.template.application.example.commands.update;

import java.util.Optional;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.domain.example.ExampleRepository;
import com.mserafin.template.infrastructure.cqrs.EventPublisher;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.CommandHandler;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class UpdateDataCommandHandler implements CommandHandler<UpdateDataCommand, Example>
{
    private final ServiceLocator dependency;

    public <T extends ServiceLocator> UpdateDataCommandHandler(final T dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public Example handle(final UpdateDataCommand command)
    {
        final Optional<ExampleRepository> repository = dependency.resolve(ExampleRepository.class);
        repository.get().update(command.getData());

        final Optional<EventPublisher> publisher = dependency.resolve(EventPublisher.class);
        final Example model = publisher.get().mergeClass(command.getData());
        model.notifyEvent(command);

        return model;
    }
}
