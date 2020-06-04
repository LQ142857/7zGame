package com.a7z.sevenzgame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Profile({"dev","test"})
@Configuration //该文件为java配置文件
@EnableSwagger2//开启swagger
public class Swagger2 {
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要扫描生成swagger文档接口的包路径，注意别写错了，错了swagger页面打开就不会有接口再上面
                .apis(RequestHandlerSelectors.basePackage("com.a7z.sevenzgame.controller"))
                .paths(PathSelectors.any())
                .build().groupName("all");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要扫描生成swagger文档接口的包路径，注意别写错了，错了swagger页面打开就不会有接口再上面
                .apis(RequestHandlerSelectors.basePackage("com.a7z.sevenzgame.controller.admin"))
                .paths(PathSelectors.any())
                .build().groupName("admin");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要扫描生成swagger文档接口的包路径，注意别写错了，错了swagger页面打开就不会有接口再上面
                .apis(RequestHandlerSelectors.basePackage("com.a7z.sevenzgame.controller.show"))
                .paths(PathSelectors.any())
                .build().groupName("show");
    }

    //api文档的一些页面基本信息
    private ApiInfo apiInfo() {
        Contact content = new Contact("7z", "http://www.7z.work", "3504566107@qq.com");
        return new ApiInfo("xxx系统接口文档", "2020-3-10更新", "1.0", "http://www.7z.work", content, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
    }
}