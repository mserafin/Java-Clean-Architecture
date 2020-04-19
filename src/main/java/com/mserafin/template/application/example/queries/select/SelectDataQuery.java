package com.mserafin.template.application.example.queries.select;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.infrastructure.cqrs.interfaces.queries.Query;


public class SelectDataQuery implements Query<Example>
{
    private final Long id;

    public SelectDataQuery(final Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
}
