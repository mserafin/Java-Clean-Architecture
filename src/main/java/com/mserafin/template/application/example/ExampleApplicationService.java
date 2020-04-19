package com.mserafin.template.application.example;

import java.util.List;

import com.mserafin.template.domain.example.Example;


public interface ExampleApplicationService
{
    List<Example> getAll();

    Example getById(Long exampleId);

    Example create(Example example);

    Example update(Example example);

    boolean remove(Long exampleId);
}
