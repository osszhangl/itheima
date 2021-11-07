package com.itheima.ui;


import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.ui
 * Description:
 *
 * @Date:2021/7/26 20:48
 * @Author:zhang'lin zhanglin@163.com
 */
public class Client {
    public static void main(String[] args) {
        //1 获取核心容器杜对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
        IAccountService as2 = (IAccountService) ac.getBean("accountService2");
        as2.saveAccount();
        IAccountService as3 = (IAccountService) ac.getBean("accountService3");
        as3.saveAccount();

    }
}
