package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.test
 * Description:使用Juni单元测试，测试我们的配置
 *
 *
 * @Date:2021/8/8 16:06
 * @Author:zhang'lin zhanglin@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")//使用代理的service
   private IAccountService as;

    @Test
    public void testTranfer(){
        as.tranfer("aaa","bbb",100f);
    }


}
