package com.mserafin.template.infrastructure.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;
import com.mserafin.template.infrastructure.rest.ErrorCodeRest;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
            .title("Examples")
            .description("This specification defines operations on the examples resource")
            .license("")
            .licenseUrl("")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("", "", ""))
            .build();
    }

    @Bean
    public Docket customImplementation(final TypeResolver typeResolver)
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation(Api.class))
            .build()
            .genericModelSubstitutes(Optional.class)
            .additionalModels(typeResolver.resolve(ErrorCodeRest.class))
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo());
    }
}
