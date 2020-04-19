package com.mserafin.template.application.example.commands.delete;

import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventListener;


public class DeleteDataCommandListener implements EventListener
{
    @Override
    public <T> void handle(final T data)
    {
        final Boolean status = (Boolean) data;
        System.out.println("DeleteDataCommandListener::listener; status=" + status);
    }
}
