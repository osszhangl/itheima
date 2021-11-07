package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import com.itheima.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 * 测试mybatis的CRUD操作
 *
 * @Date:2021/7/17 11:22
 * @Author:zhang'lin zhanglin@163.com
 */
public class MybatisTest {


    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;


    @Before
    public void init() throws Exception {
        //读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //读取sqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlsession
        session = factory.openSession(true);
        //获取到代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws Exception {
        //关闭链接之前进行事务的提交工作
//        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询所有数据
     *
     * @return
     */
    @Test
    public void testFindAll() {

        //执行sql语句
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.err.println(account);
            System.err.println(account.getUser());
        }
    }

    /**
     * 查询所有账号对应的用户信息,包含了，用户的名称和地址信息
     */
    @Test
    public void testFindAccountUser() {

        List<AccountUser> accountUsers = accountDao.findAccount();
        for (AccountUser accountUser : accountUsers) {
            System.err.println(accountUser);
        }

    }
}

