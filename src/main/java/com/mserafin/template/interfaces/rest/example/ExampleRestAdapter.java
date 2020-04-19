package com.mserafin.template.interfaces.rest.example;

import java.util.List;

import com.mserafin.template.interfaces.api.ExampleRest;


public interface ExampleRestAdapter
{
    ExampleRest create(ExampleRest exampleRest);

    void deleteById(Long exampleId);

    List<ExampleRest> findAll();

    ExampleRest findById(Long exampleId);

    ExampleRest update(Long exampleId, ExampleRest exampleRest);
}
