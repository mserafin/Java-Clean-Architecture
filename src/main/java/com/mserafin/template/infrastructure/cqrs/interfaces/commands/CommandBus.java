package com.mserafin.template.infrastructure.cqrs.interfaces.commands;

public interface CommandBus
{
    <TCommand extends Command<TResult>, TResult> TResult sendCommand(TCommand command) throws ClassNotFoundException;
}
