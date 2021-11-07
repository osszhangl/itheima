package com.itheima.config;


import com.google.common.base.Predicates;
import com.itheima.anno.MyAnnotationSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by zhanglin on 2021/7/21.
 */
@Configuration
public class SwaggerConifguration {

    /**
     * 创建Docket类型对象，并使用spring容器管理
     * Docket是Swagger中的全局配置对象
     * @return
     */
    @Bean
    public Docket docket(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo =
                new ApiInfoBuilder().contact(new Contact(
                        //配置swagger文档主题内容
                        "OSS-ZhangLin的Swagger开发文档",//文档发布者名称
                        "http://www.bjsxt.com",             //文档发布者的网站地址，一般是企业网站
                        "admin@zhanglin.com")               //文档发布者的邮箱
                ).title("Swagger框架学习帮助文档")
                        .description("Swagger框架学习帮助文档详情描述文档-Swagger")
                        .version("1.1.0")
                        .build();

        docket.apiInfo(apiInfo);
        docket
                .select()//获取Docket中的选择器。返回AipSelectBuilder.构件选择器，如如扫描什么包的注解
                .apis(
                        Predicates.not(//取反，false--》true   true—》false
                                RequestHandlerSelectors.withMethodAnnotation(//当方法上有注解的时候返回true
                                        MyAnnotationSwagger.class)))//方法上有什么注解的时候返回true
                .build();
        //.apis(RequestHandlerSelectors.basePackage("com.itheima.controller"));//设定扫描的那个中的注解

        return docket;

    }


}
