package com.cloudnote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration{

    @Bean
    public Docket docket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("云之印cloudnote")
                        .description("cloudnote项目接口文档")
                        .version("1.0")
                        .contact(new Contact("肖恩","https://www.bilibili.com","2915371450@qq.com"))
                        .build()
                )
                .select()
                //Controller所在的包
                .apis(RequestHandlerSelectors.basePackage("com.cloudnote.controller"))
                .build();
    }


}
