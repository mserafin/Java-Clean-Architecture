package com.mserafin.template.application.example.commands.update;

import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventListener;


public class UpdateDataCommandListener implements EventListener
{
    @Override
    public <T> void handle(final T data)
    {
        final Boolean status = (Boolean) data;
        System.out.println("UpdateDataCommandListener::listener; status=" + status);
    }
}
