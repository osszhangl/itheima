package com.itheima;

import com.itheima.service.IAcountService;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima
 * Description: c测试AOP配置
 *
 * @Date:2021/9/12 14:02
 * @Author:zhang'lin zhanglin@163.com
 */
public class AOPTest {


    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAcountService as = (IAcountService)ac.getBean("accountService");
        as.saveAccount();

    }

}
