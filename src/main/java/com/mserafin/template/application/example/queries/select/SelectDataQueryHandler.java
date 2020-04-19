package com.mserafin.template.application.example.queries.select;

import java.util.Optional;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.domain.example.ExampleRepository;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.QueryHandler;
import com.mserafin.template.infrastructure.servicelocator.ServiceLocator;


public class SelectDataQueryHandler implements QueryHandler<SelectDataQuery, Example>
{
    private final ServiceLocator dependency;

    public <T extends ServiceLocator> SelectDataQueryHandler(final T dependency)
    {
        this.dependency = dependency;
    }

    @Override
    public Example execute(final SelectDataQuery query)
    {
        final Optional<ExampleRepository> repository = dependency.resolve(ExampleRepository.class);
        return repository.get().findById(query.getId());
    }
}
