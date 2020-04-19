package com.mserafin.template.infrastructure.servicelocator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;


public class ServiceLocatorImpl implements ServiceLocator
{
    private final Map<Class<?>, Supplier<?>> handlers = new HashMap<>();

    @Override
    public <T> Optional<T> resolve(final Class type)
    {
        try
        {
            final Class<?> handlerClass = Class.forName(type.getName());
            return Optional.ofNullable((T) (handlers.get(handlerClass).get()));
        }
        catch (final ClassNotFoundException e)
        {
            return Optional.empty();
        }
    }

    @Override
    public <T> void register(final Class type, final Supplier<T> resolver)
    {
        try
        {
            final Class<?> handlerClass = Class.forName(type.getName());
            handlers.putIfAbsent(handlerClass, resolver);
        }
        catch (final ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close()
    {
        handlers.clear();
    }
}
