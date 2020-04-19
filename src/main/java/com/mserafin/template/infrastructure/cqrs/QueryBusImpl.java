package com.mserafin.template.infrastructure.cqrs;

import java.util.Objects;
import java.util.Optional;

import com.mserafin.template.infrastructure.cqrs.common.ObservableBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.Query;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.QueryBus;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.QueryHandler;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class QueryBusImpl extends ObservableBus<Query> implements QueryBus
{
    private final ServiceLocator dependency;

    public QueryBusImpl(final ServiceLocator dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public <TQuery extends Query<TResult>, TResult> TResult process(final TQuery query) throws ClassNotFoundException
    {
        if (Objects.equals(query, null))
        {
            throw new IllegalArgumentException();
        }

        final Optional<QueryHandler> queryHandler = dependency.resolve(query.getClass());
        if (!queryHandler.isPresent())
        {
            throw new ClassNotFoundException("Not found handler for Query: " + query);
        }

        return (TResult) queryHandler.get().execute(query);
    }

//    private final QueryHandler queryHandler;
//
//    public QueryBusImpl(final QueryHandler queryHandler)
//    {
//        this.queryHandler = queryHandler;
//    }
//
//    @Override
//    public <TQuery extends Query<TResult>, TResult> TResult process(final TQuery query)
//    {
//        if (Objects.equals(query, null))
//        {
//            throw new IllegalArgumentException();
//        }
//
//        return (TResult) queryHandler.execute(query);
//    }
}
