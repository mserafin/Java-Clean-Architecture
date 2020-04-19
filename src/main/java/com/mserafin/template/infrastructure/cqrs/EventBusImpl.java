package com.mserafin.template.infrastructure.cqrs;

import java.util.ArrayList;
import java.util.List;

import com.mserafin.template.infrastructure.cqrs.common.ObservableBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.events.Event;
import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventListener;


public class EventBusImpl extends ObservableBus<Event> implements EventBus<EventListener>
{
    private final List<EventListener> events = new ArrayList<>();

    @Override
    public void publish(final EventListener event)
    {
        events.add(event);
    }

    @Override
    public <T> void publisher(final T data)
    {
        events.forEach(it -> it.handle(data));
    }

    @Override
    public void unregister(final EventListener event)
    {
        events.removeIf(it -> it.equals(event));
    }
}
