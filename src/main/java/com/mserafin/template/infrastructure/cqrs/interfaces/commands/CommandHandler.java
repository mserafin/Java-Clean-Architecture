package com.mserafin.template.infrastructure.cqrs.interfaces.commands;

public interface CommandHandler<TCommand extends Command, TResult>
{
    TResult handle(TCommand command);
}
