package com.mserafin.template.infrastructure.repository.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.domain.example.ExampleRepository;


@Repository
public class ExampleRepositoryImpl implements ExampleRepository
{
    private static final List<Example> storage = new ArrayList<>();

    public ExampleRepositoryImpl()
    {
        storage.add(new Example(1L, "Test 1"));
        storage.add(new Example(2L, "Test 2"));
        storage.add(new Example(3L, "Test 3"));
    }

    @Override
    public List<Example> findAll()
    {
        return storage;
    }

    @Override
    public Example findById(final Long exampleId)
    {
        return storage.stream()
            .filter(it -> Objects.equals(it.id, exampleId))
            .findFirst().orElse(null);
    }

    @Override
    public long create(final Example example)
    {
        example.id = storage.stream().map(it -> it.id).max(Comparator.comparing(Long::valueOf)).orElse(0L) + 1L;
        storage.add(example);

        return example.id;
    }

    @Override
    public Example update(final Example example)
    {
        deleteById(example.id);
        storage.add(example);
        return null;
    }

    @Override
    public void deleteById(final Long exampleId)
    {
        storage.removeIf(it -> Objects.equals(it.id, exampleId));
    }
}
