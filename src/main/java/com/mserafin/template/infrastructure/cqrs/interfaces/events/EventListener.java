package com.mserafin.template.infrastructure.cqrs.interfaces.events;

public interface EventListener
{
    <T> void handle(T data);
}
