package com.mserafin.template.application.example.commands.create;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventListener;


public class CreateDataCommandListener implements EventListener
{
    private final Long id;
    private final String name;

    public CreateDataCommandListener(final Long id, final String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public <T> void handle(final T data)
    {
        final Example example = (Example) data;
        System.out.println("CreateDataCommandListener::handle; data.id=" + example.id + "; data.name=" + example.name + "; id=" + id);
    }
}
