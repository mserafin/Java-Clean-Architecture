package com.mserafin.template.interfaces.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mserafin.template.interfaces.rest.example.ExampleRestAdapter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-17T12:03:36.726Z[GMT]")
@Api(value = "example", tags = {"example"})
@RestController
public class ExampleRestApiController implements ExampleRestApi
{
    @Autowired
    private ExampleRestAdapter adapter;

    @Override
    public ExampleRest create(
        @ApiParam(value = "New example.", required = true)
        @Valid @RequestBody ExampleRest body)
    {
        return adapter.create(body);
    }

    @Override
    public void deleteById(
        @ApiParam(value = "The primary key of config snapshot.", required = true)
        @PathVariable("exampleId") Long exampleId)
    {
        adapter.deleteById(exampleId);
    }

    @Override
    public List<ExampleRest> findAll()
    {
        return adapter.findAll();
    }

    @Override
    public ExampleRest findById(
        @ApiParam(value = "The primary key of config snapshot.", required = true)
        @PathVariable("exampleId") Long exampleId)
    {
        return adapter.findById(exampleId);
    }

    @Override
    public ExampleRest update(
        @ApiParam(value = "example to update.", required = true) @Valid @RequestBody ExampleRest body,
        @ApiParam(value = "The primary key of config snapshot.", required = true) @PathVariable("exampleId") Long exampleId)
    {
        return adapter.update(exampleId, body);
    }
}
