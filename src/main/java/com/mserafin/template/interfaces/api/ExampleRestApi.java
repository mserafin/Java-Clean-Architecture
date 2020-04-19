package com.mserafin.template.interfaces.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mserafin.template.infrastructure.rest.ErrorCodeRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-17T12:03:36.726Z[GMT]")
@Api(value = "example", tags = {"example"})
public interface ExampleRestApi
{
    @ApiOperation(value = "Create new example.", nickname = "create", notes = "", response = ExampleRest.class, tags = {"example",})
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = ExampleRest.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorCodeRest.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorCodeRest.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ErrorCodeRest.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorCodeRest.class)})
    @RequestMapping(value = "/example",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.POST)
    ExampleRest create(@ApiParam(value = "New example.", required = true) @Valid @RequestBody ExampleRest body
    );

    @ApiOperation(value = "Delete example by ID.", nickname = "deleteById", notes = "", tags = {"example",})
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorCodeRest.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ErrorCodeRest.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorCodeRest.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorCodeRest.class)})
    @RequestMapping(value = "/example/{exampleId}",
        produces = {"application/json"},
        method = RequestMethod.DELETE)
    void deleteById(
        @ApiParam(value = "The primary key of config snapshot.", required = true) @PathVariable("exampleId") Long exampleId
    );

    @ApiOperation(value = "Get all examples.", nickname = "findAll", notes = "", response = ExampleRest.class, responseContainer = "List",
        tags = {"example",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ExampleRest.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorCodeRest.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorCodeRest.class)})
    @RequestMapping(value = "/example",
        produces = {"application/json"},
        method = RequestMethod.GET)
    List<ExampleRest> findAll();

    @ApiOperation(value = "Get example by ID.", nickname = "findById", notes = "", response = ExampleRest.class, tags = {"example",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ExampleRest.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorCodeRest.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorCodeRest.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorCodeRest.class)})
    @RequestMapping(value = "/example/{exampleId}",
        produces = {"application/json"},
        method = RequestMethod.GET)
    ExampleRest findById(
        @ApiParam(value = "The primary key of config snapshot.", required = true) @PathVariable("exampleId") Long exampleId
    );

    @ApiOperation(value = "Update example by ID.", nickname = "update", notes = "", response = ExampleRest.class, tags = {"example",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Updated", response = ExampleRest.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorCodeRest.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = ErrorCodeRest.class),
        @ApiResponse(code = 403, message = "Forbidden", response = ErrorCodeRest.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorCodeRest.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorCodeRest.class)})
    @RequestMapping(value = "/example/{exampleId}",
        produces = {"application/json"},
        consumes = {"application/json"},
        method = RequestMethod.PUT)
    ExampleRest update(@ApiParam(value = "example to update.", required = true) @Valid @RequestBody ExampleRest body
        , @ApiParam(value = "The primary key of config snapshot.", required = true) @PathVariable("exampleId") Long exampleId
    );
}
