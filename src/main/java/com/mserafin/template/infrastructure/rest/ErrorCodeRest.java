package com.mserafin.template.infrastructure.rest;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "ErrorInfo", description = "A data structure describing an error.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class ErrorCodeRest
{
    @ApiModelProperty(value = "The error code.", readOnly = true)
    public String errorCode;

    @ApiModelProperty(value = "Additional debugging information. For internal use only.", readOnly = true)
    public Set<String> debugInfo;

    /**
     * Jackson...
     */
    public ErrorCodeRest()
    {
    }

    public ErrorCodeRest(final String errorCode, final Set<String> debugInfo)
    {
        this.errorCode = errorCode;
        this.debugInfo = debugInfo;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        final ErrorCodeRest that = (ErrorCodeRest) o;
        return Objects.equals(errorCode, that.errorCode) &&
            Objects.equals(debugInfo, that.debugInfo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(errorCode, debugInfo);
    }

    @Override
    public String toString()
    {
        return "ErrorCodeRest{" +
            "errorCode='" + errorCode + '\'' +
            ", debugInfo=" + debugInfo +
            '}';
    }
}
