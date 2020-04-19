package com.mserafin.template.infrastructure.cqrs.interfaces.events;

public interface EventBus<T extends EventListener>
{
    void publish(T event);

    <E> void publisher(E data);

    void unregister(T event);
}
