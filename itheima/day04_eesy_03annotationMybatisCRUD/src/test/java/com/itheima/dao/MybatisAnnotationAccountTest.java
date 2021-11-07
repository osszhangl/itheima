package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 * 测试mybatis的注解，实现一对多的查询
 *
 * @Date:2021/7/17 11:22
 * @Author:zhang'lin zhanglin@163.com
 */
public class MybatisAnnotationAccountTest {
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
        session = factory.openSession();
        //获取到代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws Exception {
        //关闭链接之前进行事务的提交工作
        session.commit();
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
            System.out.println(account);
//            System.err.println(account.getUser());
        }
    }

    /**
     * 测试根据id查询用户
     */
    @Test
    public void testFandById() {
        List<Account> accounts = accountDao.findByUid(21);
        for (Account account:accounts) {
            System.err.println(account);
            System.err.println(account.getUser());
        }
    }








}
