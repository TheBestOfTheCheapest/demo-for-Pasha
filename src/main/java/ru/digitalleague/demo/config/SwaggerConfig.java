/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("ru.digitalleague.demo.controller"))
                    .paths(PathSelectors.any())
                    .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "REST API for CV application and online University",
                "Hello there! We wrote a new service for our company. Have a fun!",
                "API v1.0",
                "Terms of service",
                new Contact("Andrew Yelmanov", "no website", "aelmanov@phoenixit.ru"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
