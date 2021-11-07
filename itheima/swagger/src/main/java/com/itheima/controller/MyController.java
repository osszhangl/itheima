package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

/**
 * Created by zhanglin on 2021/7/21.
 */
@RestController
public class MyController {

    @PostMapping("/post")
    public String post(){

        return "post";
    }
    @GetMapping("/get")
    public String get(String a ,String b){

        return "get";
    }
    @RequestMapping("/req")
    public String req(String m){

        return "req";
    }




}
