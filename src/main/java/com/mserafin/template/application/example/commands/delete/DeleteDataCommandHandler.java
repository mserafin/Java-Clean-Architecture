package com.mserafin.template.application.example.commands.delete;

import java.util.Optional;

import com.mserafin.template.domain.example.ExampleRepository;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.CommandHandler;
import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventBus;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class DeleteDataCommandHandler implements CommandHandler<DeleteDataCommand, Boolean>
{
    private final ServiceLocator dependency;

    public <T extends ServiceLocator> DeleteDataCommandHandler(final T dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public Boolean handle(final DeleteDataCommand command)
    {
        final Optional<ExampleRepository> repository = dependency.resolve(ExampleRepository.class);
        repository.get().deleteById(command.getId());

        final Boolean status = false;
        final Optional<EventBus> eventBus = dependency.resolve(EventBus.class);
        eventBus.get().publisher(status);
        return status;
    }
}
