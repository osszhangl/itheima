package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.test
 * Description:
 *
 * @Date:2021/8/8 16:06
 * @Author:zhang'lin zhanglin@163.com
 */
public class AccountServiceTest {

    @Test
    public void testFindAll(){
        //读取配置文件，获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //执行方法
        List<Account> accounts = as.findAll();
        for (Account account:accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testFindByAcountId(){
        //读取配置文件，获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //执行方法

        System.out.println(as.findAccountById(1));

    }

    @Test
    public void testSave(){
        //读取配置文件，获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //执行方法,uid应为别的表的主键，这边不能直接插入uid
        Account account = new Account();
        account.setUid(55);
        account.setMoney(66.66);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //读取配置文件，获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //执行方法
        Account account = new Account();
        account.setId(1);
        account.setUid(21);
        account.setMoney(5000.0);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //读取配置文件，获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取业务层对象
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //执行方法


    }



}
