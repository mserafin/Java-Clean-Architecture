package com.mserafin.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;


@SpringBootApplication(exclude = {ArtemisAutoConfiguration.class})
public class TemplateApiApplication
{
    public static void main(final String[] args)
    {
        SpringApplication.run(TemplateApiApplication.class, args);
    }
}
