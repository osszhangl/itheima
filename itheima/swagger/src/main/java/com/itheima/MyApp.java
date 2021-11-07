package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * EnableSwagger2 他是springfox提供的一个注解，
 * 代表swagger的相关技术开启，
 * 会扫描当前类所有包，及子包中所有的类型中的注解
 * ，做swagger文档的定制
 * Created by zhanglin on 2021/7/21.
 */
@SpringBootApplication
@EnableSwagger2
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class,args);
    }


}
