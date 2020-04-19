package com.mserafin.template.application.example.queries.list;

import java.util.List;
import java.util.Optional;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.domain.example.ExampleRepository;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.QueryHandler;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class ListDataQueryHandler implements QueryHandler<ListDataQuery, List<Example>>
{
    private final ServiceLocator dependency;

    public <T extends ServiceLocator> ListDataQueryHandler(final T dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public List<Example> execute(final ListDataQuery query)
    {
        final Optional<ExampleRepository> repository = dependency.resolve(ExampleRepository.class);
        return repository.get().findAll();
    }
}

