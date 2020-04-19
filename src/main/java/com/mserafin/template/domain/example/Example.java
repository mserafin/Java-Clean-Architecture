package com.mserafin.template.domain.example;

import com.mserafin.template.application.example.commands.create.CreateDataCommandListener;
import com.mserafin.template.infrastructure.cqrs.common.EntityPublisher;


public class Example extends EntityPublisher
{
    public Long id;
    public Integer version;
    public String name;

    public Example()
    {
        super();
    }

    public Example(final Long id, final String name)
    {
        super();
        this.id = id;
        this.name = name;
        this.version = 1;
    }

    public <T> void notifyEvent(final T data)
    {
        this.apply(new CreateDataCommandListener(id, name));
//        this.apply(new DeleteDataCommandListener(id));
    }
}
