/**
package com.intecsec.mall.user.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// @Configuration
// @EnableSwagger2
// @EnableOpenApi
// @EnableWebMvc
public class Swagger2Config {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("appApi")
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo webApiInfo() {

        return new ApiInfoBuilder()
                .title("C端-API文档")
                .description("C端微服务接口定义")
                .version("1.0")
                .contact(new Contact("peter",
                        "https://www.intecsec.com",
                        "372975425@qq.com"))
                .build();
    }
}
*/