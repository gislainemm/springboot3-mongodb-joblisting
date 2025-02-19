package com.demo.joblisting.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Job Listing API",
        version = "1.0",
        description = "Spring Boot 3 | MongoDB - Job Listing API Demo Project"
    )
)
public class OpenAPIConfig {

}