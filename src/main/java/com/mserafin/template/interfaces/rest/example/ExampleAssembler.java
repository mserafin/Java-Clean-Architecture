package com.mserafin.template.interfaces.rest.example;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.interfaces.api.ExampleRest;


public final class ExampleAssembler
{
    public static ExampleRest toExampleRest(final Example arg)
    {
        Assert.notNull(arg, "Example must not be null");

        final ExampleRest that = new ExampleRest();
        that.setExampleId(arg.id);
        that.setVersion(arg.version);
        that.setName(arg.name);
        return that;
    }

    public static Example toExample(final ExampleRest arg)
    {
        Assert.notNull(arg, "ExampleRest must not be null.");

        final Example that = new Example();
        that.id = Long.valueOf(arg.getExampleId());
        that.version = Integer.valueOf(arg.getVersion());
        that.name = arg.getName();
        return that;
    }

    public static List<Example> toExample(final List<ExampleRest> brandRests)
    {
        return brandRests.stream().map(ExampleAssembler::toExample).collect(Collectors.toList());
    }

    public static List<ExampleRest> toExampleRest(final List<Example> brands)
    {
        return brands.stream().map(ExampleAssembler::toExampleRest).collect(Collectors.toList());
    }
}