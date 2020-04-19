package com.mserafin.template.interfaces.rest.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mserafin.template.application.example.ExampleApplicationService;
import com.mserafin.template.interfaces.api.ExampleRest;


@Component
public class ExampleRestAdapterImpl implements ExampleRestAdapter
{
    private final ExampleApplicationService exampleApplicationService;

    @Autowired
    public ExampleRestAdapterImpl(final ExampleApplicationService exampleApplicationService)
    {
        this.exampleApplicationService = exampleApplicationService;
    }

    @Override
    public ExampleRest create(final ExampleRest exampleRest)
    {
        return ExampleAssembler.toExampleRest(
            exampleApplicationService.create(ExampleAssembler.toExample(exampleRest)));
    }

    @Override
    public void deleteById(final Long exampleId)
    {
        exampleApplicationService.remove(exampleId);
    }

    @Override
    public List<ExampleRest> findAll()
    {
        return ExampleAssembler.toExampleRest(exampleApplicationService.getAll());
    }

    @Override
    public ExampleRest findById(final Long exampleId)
    {
        return ExampleAssembler.toExampleRest(exampleApplicationService.getById(exampleId));
    }

    @Override
    public ExampleRest update(final Long exampleId, final ExampleRest exampleRest)
    {
        return ExampleAssembler.toExampleRest(
            exampleApplicationService.update(ExampleAssembler.toExample(exampleRest)));
    }
}
