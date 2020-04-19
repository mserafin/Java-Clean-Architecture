package com.mserafin.template.infrastructure.cqrs.interfaces.queries;

public interface QueryBus
{
    <TQuery extends Query<TResult>, TResult> TResult process(TQuery query) throws ClassNotFoundException;
}
