package com.mserafin.template.infrastructure.cqrs;

import com.mserafin.template.infrastructure.cqrs.common.EntityPublisher;


public class EventPublisher
{
    public <T extends EntityPublisher> T mergeClass(final T object)
    {
        return (T) object.register(event -> event.handle(object));
    }
}
