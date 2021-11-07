package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.anno
 * Description:
 * @Target -描述当前的注解可以定义在什么资源上
 * 属性value
 *      -定义具体的资源，包括：
 *      -ElementType.METHOD 可以定义在方法上
 *      -ElementType.TYPE 可以定义在 类型上
 *      -ElementType.FIELD 可以定义在属性
 *      -ElementType.PARAMETER 可以定义在方法参数上
 *@Retention -当前注解在什么时候有效
 *      属性value
 *      -定义具体的生效标记
 *      -RetentionPolicy.RUNTIME -运行时有效
 *      -RetentionPolicy.SOURCE -源码中有效
 *      -RetentionPolicy.CLASS -字节码有效
 *
 * @Date:2021/7/21 21:49
 * @Author:zhang'lin zhanglin@163.com
 */
@Target(value={ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationSwagger {

    //自定义注解中的属性，相当于@MyAnnotationSwagger（value""）
    String value() default "";




}
