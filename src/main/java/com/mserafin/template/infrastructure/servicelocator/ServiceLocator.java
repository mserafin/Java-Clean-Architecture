package com.mserafin.template.infrastructure.servicelocator;

import java.util.Optional;
import java.util.function.Supplier;


public interface ServiceLocator extends AutoCloseable
{
    <T> Optional<T> resolve(Class type);

    <T> void register(Class type, Supplier<T> resolver);
}
