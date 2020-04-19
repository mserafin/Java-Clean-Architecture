package com.mserafin.template.interfaces.api;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * Example
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-17T12:03:36.726Z[GMT]")
public class ExampleRest
{
    @JsonProperty("exampleId")
    private Long exampleId = 0l;

    @JsonProperty("version")
    private Integer version = 1;

    @JsonProperty("name")
    private String name = null;

    public ExampleRest exampleId(Long exampleId)
    {
        this.exampleId = exampleId;
        return this;
    }

    /**
     * Example entity id.
     * @return exampleId
     **/
    @ApiModelProperty(required = true, value = "Example entity id.")
    @NotNull

    public Long getExampleId()
    {
        return exampleId;
    }

    public void setExampleId(Long exampleId)
    {
        this.exampleId = exampleId;
    }

    public ExampleRest version(Integer version)
    {
        this.version = version;
        return this;
    }

    /**
     * version example.
     * @return version
     **/
    @ApiModelProperty(value = "version example.")

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public ExampleRest name(String name)
    {
        this.name = name;
        return this;
    }

    /**
     * Name example.
     * @return name
     **/
    @ApiModelProperty(required = true, value = "Name example.")
    @NotNull

    @Size(max = 50)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        ExampleRest exampleRest = (ExampleRest) o;
        return Objects.equals(this.exampleId, exampleRest.exampleId) &&
            Objects.equals(this.version, exampleRest.version) &&
            Objects.equals(this.name, exampleRest.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(exampleId, version, name);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class Example {\n");
        sb.append("    exampleId: ").append(toIndentedString(exampleId)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

