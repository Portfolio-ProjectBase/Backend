package com.project.portfolio.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portfolio API")
                        .version("1.0")
                        .description("Portfolio API Documentation"));
    }

    @Bean
    public GroupedOpenApi resumeApi() {
        return GroupedOpenApi.builder()
                .group("resumes")
                .pathsToMatch("/api/resumes/**")
                .build();
    }
}
