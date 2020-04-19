package com.mserafin.template.infrastructure.cqrs;

import java.util.Objects;
import java.util.Optional;

import com.mserafin.template.infrastructure.cqrs.common.ObservableBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.Command;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.CommandBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.CommandHandler;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class CommandBusImpl extends ObservableBus<Command> implements CommandBus
{
    private final ServiceLocator dependency;

    public CommandBusImpl(final ServiceLocator dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public <TCommand extends Command<TResult>, TResult> TResult sendCommand(final TCommand command) throws ClassNotFoundException
    {
        if (Objects.equals(command, null))
        {
            throw new IllegalArgumentException();
        }

        final Optional<CommandHandler> commandHandler = dependency.resolve(command.getClass());
        if (!commandHandler.isPresent())
        {
            throw new ClassNotFoundException("Not found handler for Command: " + command);
        }

        return (TResult) commandHandler.get().handle(command);
    }
}
