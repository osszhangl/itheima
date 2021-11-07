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
    private SqlSessionFactory factory;
    private IUserDao userDao;


    @Before
    public void init() throws Exception {
        //读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //读取sqlsessionFactory
         factory = new SqlSessionFactoryBuilder().build(in);
        //获取sqlsession
        session = factory.openSession();
        //获取到代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        //关闭链接之前进行事务的提交工作
//        session.commit();
//        session.close();
//        in.close();
    }

    /**
     * 测试一级缓存
     *
     * @return
     */
    @Test
    public void testFirstCache() {

        //执行sql语句
        List<User> users = userDao.findAll();
        User user1 = userDao.findById(21);
        System.err.println(user1);

        /**
         * 没有手动关闭session的时候，两个对象时同一个对象，
         * 关闭sqlsession之后，清楚了缓存，重新创建sqlsession对象，和代理对象
         * 执行sql语句时，发现两个user时不同的对象，同时也是执行了两次的sql，创建了两个connection
         */
//        session.close();
//        SqlSession session = factory.openSession();
//        userDao =session.getMapper(IUserDao.class);
        //这个上面的一样的效果
        session.clearCache();

        User user2 = userDao.findById(21);
        System.err.println(user2);
        System.err.println(user1==user2);

    }


    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondCache(){
        /**
         * 二级缓存的开启要配置，才能支持：
         *  第一步：让mybatis框架支持二级缓存（在sqlMapConfiguration中配置）
            第二步：让当前的映射文件支持二级缓存（在IUserDao.xml文件中配置）
            第三步：让当前的操作支持二级缓存（在select标签中配置）

         * 从输出的日志我们能可以看到，输出的user时两个不同的对象，
         * 但是却只执行了一次sql语句，说明在二级缓存中把数据缓存起来了，
         * 只是重新创建了对象把数据封装进去
         *
         */

        SqlSession session1 = factory.openSession();
        IUserDao userDao1 = session1.getMapper(IUserDao.class);
        User user1 = userDao1.findById(21);
        System.err.println(user1);
        session1.close();//一级缓存消失


        SqlSession session2 = factory.openSession();
        IUserDao userDao2 = session2.getMapper(IUserDao.class);
        User user2 = userDao2.findById(21);
        System.err.println(user2);
        session2.close();//一级缓存

        System.err.println(user1==user2);



    }
}

