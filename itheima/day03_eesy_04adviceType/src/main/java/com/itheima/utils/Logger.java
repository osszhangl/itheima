package com.itheima.utils;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.utils
 * Description: 用于记录日志的工具类，他里面提供了公共代码
 *
 * @Date:2021/9/12 13:12
 * @Author:zhang'lin zhanglin@163.com
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){

        System.out.println("Logger类中的printLog方法开始记录日志了");
    }
}
