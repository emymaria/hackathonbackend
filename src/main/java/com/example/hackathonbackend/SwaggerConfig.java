package com.example.hackathonbackend;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("hackathon-api")
                .apiInfo(getApiInfo()).select()
                .build();
    }

    public ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("Hackathon apis").description("APIs for hackathon")
                .version("1").build();
    }
}
