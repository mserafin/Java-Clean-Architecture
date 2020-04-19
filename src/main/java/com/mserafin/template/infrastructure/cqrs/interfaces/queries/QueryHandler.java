package com.mserafin.template.infrastructure.cqrs.interfaces.queries;

public interface QueryHandler<TQuery extends Query<TResult>, TResult>
{
    TResult execute(TQuery query);
}
