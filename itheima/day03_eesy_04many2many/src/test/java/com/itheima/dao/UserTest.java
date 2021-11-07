package com.itheima.dao;

import com.itheima.domain.User;
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
 * 测试mybatis的CRUD操作
 *
 * @Date:2021/7/17 11:22
 * @Author:zhang'lin zhanglin@163.com
 */
public class UserTest {


    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;


    @Before
    public void init() throws Exception {
        //读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //读取sqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlsession
        session = factory.openSession(true);
        //获取到代理对象
        userDao = session.getMapper(IUserDao.class);
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
        List<User> users = userDao.findAll();
            for (User user:users){
                System.err.println(user);
                System.err.println(user.getRoles());

            }
        }

}

