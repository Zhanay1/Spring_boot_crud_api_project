package com.crudproject.Crud.Api.Project.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket{
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crudproject.Crud.Api.Project"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndsPointsInfo())
    }

    private fun apiEndsPointsInfo(): ApiInfo{
        return ApiInfoBuilder().title("CRUD Rest API in Spring boot")
                .description("User registration Rest API")
                .contact(Contact("Zhanay Kalimbetov", "www.iitu.kz", "zkalimbetov2@gmail.com"))
                .build()
    }

}