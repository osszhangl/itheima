package com.itheima.test;

import config.SpringConfiguration;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.test
 * Description:     spring整合junit配置
 *                  1、导入soring整合junit的jar坐标
 *                  2、使用jubit提供的一个注解把原来有的main方法替换掉，替换成spring提供的
 *                  3、告知spring的运行器，spring和ioc的创建是基于xml还是注解的，并且说明位置
 *                  @ContextConfiguration
 *                              locations：指定xml的文件位置，加上classpath关键字，表示在类路径下
 *                              classes：指定注解类所在地位置
 *                    当我们使用的spring 5.x版本的时候，要求junit的jar必须是4.12及以上版本
 *
 *
 * @Date:2021/8/8 16:06
 * @Author:zhang'lin zhanglin@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
        //读取配置文件，获取容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //获取业务层对象
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
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
