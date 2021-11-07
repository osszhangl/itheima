package com.itheima.cglib;

import com.itheima.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.proxy
 * Description:模拟一个消费者
 *
 * @Date:2021/9/2 16:19
 * @Author:zhang'lin zhanglin@163.com
 */
public class client {

    public static void main(String[] args) {
        final Producer producer =new Producer();//method.invoke 调用的对象必须是final
//        producer.saleProducer(1000f);//付钱，获取产品

        /**
         * 动态代理：
         *      特点：字节码随用随创建，随用随加载
         *      作用：不修改源码的基础上对方法增强
         *      分类：
         *          基于子类的动态代理：
         *                  涉及的类：Enhancer
         *                  提供者：第三方cglib库
         *          如何创建代理对象：
         *                  使用enhancer类中的create方法
         *           创建代理对象的要求：
         *                  被代理类不能是最终类
         *           create方法的参数：
         *                   class:字节码
         *                          用于指定被代理对象的字节码
         *                   callback：用于提供增强的代码
         *                          他是让我们写如何代理。我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类
         *                          但不是必须的。此接口的实现类都是谁用谁写
         *
         *                          我们一般写的都是该接口（callback）的子接口实现类：MethodInterceptor
         *
         */
        Producer enhancerProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数和基于接口方式代理中invoke方法的参数是一样的
             * @param methodProxy ：当前执行方法的代理对象（一般比较少用）
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //提供代码增强
                Object returnValue =null;
                //1、获取方法执行的参数
                Float money = (Float) args[0];
                //2、判断当前执行的方法是不是销售
                if ("saleProducer".equals(method.getName())){
                    method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        enhancerProducer.saleProducer(2000f);
    }



}
