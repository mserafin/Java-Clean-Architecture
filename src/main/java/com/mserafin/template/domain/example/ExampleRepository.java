package com.mserafin.template.domain.example;

import java.util.List;


public interface ExampleRepository
{
    List<Example> findAll();

    Example findById(Long exampleId);

    long create(Example example);

    Example update(Example example);

    void deleteById(Long exampleId);
}
