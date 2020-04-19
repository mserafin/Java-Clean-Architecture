package com.mserafin.template.infrastructure.cqrs.common;

import java.util.Optional;
import java.util.function.Consumer;

import com.mserafin.template.infrastructure.cqrs.interfaces.events.EventListener;


public abstract class EntityPublisher
{
    private Optional<Consumer<EventListener>> event = Optional.empty();

    public EntityPublisher register(final Consumer<EventListener> event)
    {
        this.event = Optional.ofNullable(event);
        return this;
    }

    public <T extends EventListener> void apply(final T event)
    {
        this.event.ifPresent(it -> it.accept(event));
        //event.handle(this);
    }
}
