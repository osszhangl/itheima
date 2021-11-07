package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.test
 * Description:
 *
 * @Date:2021/7/11 13:02
 * @Author:zhang'lin zhanglin@163.com
 */
public class MybatisTest {

    /**
     *入门案例测试
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        1、读取配置文件,
        /**
         * 在读取配置文件的时候，我们一般会使用绝对路径和相对路径两种方式，
         * 但是在生产环境中，我们一般都使用：
         * 1、使用类加载器，他只能读取类路径的配置文件
         * 2、使用servletContext对象的getRealPath()这个获取到的就是文件的绝对路径
         */
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

//        2、创建SqlSessionFactory工厂
        /**builder是一个构件者，这里使用构件者模式创建工厂对象
         * 构建者模式的优点：把对象的创建细节隐藏，是使用者直接电用方法即可拿到对象
         */
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
//        3、使用工厂生产SqlSession对象
        /**生产SqlSession使用了工厂模式，优点：解耦（降低类之间的依赖关系）
         */
        SqlSession session=factory.openSession();
//        4、使用SqlSession创建Dap接口的代理对象
        /**创建dao接口实现代理模式，优势：不修改源码的基础基础上对已有的方法增强模式
         */
        IUserDao userdao=session.getMapper(IUserDao.class);
//        5、使用代理对象自行方法
        List<User> users = userdao.findAll();
        for (User user:users ){
            System.out.println(user);
        }
//        6、释放资源
        session.close();
        in.close();

    }





}
