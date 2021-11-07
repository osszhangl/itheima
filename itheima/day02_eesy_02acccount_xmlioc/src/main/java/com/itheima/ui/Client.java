package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceImp;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.ui
 * Description:
 *
 * @Date:2021/7/26 20:48
 * @Author:zhang'lin zhanglin@163.com
 */
public class Client {


    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：他可以加载类路经下的配置文件，要求配置文件必须在类路径下，不在的话，加载不不了。（实际开发中这种方式常用）
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径的配置文件（必须具有访问该路径的权限）
     *      AnnotationConfigApplicationContext：他用于读取注解创建容器的配置文件
     *
     *核心容器的两个接口引发的问题：
     * ApplicationConext：  对于一次创建的对象使用这种方式（单例对象使用），实际开发中，一般使用这种方式比较多
     *          他在构建核心容器时，创建对象采取的策略时立即加载的方式，也就是说，只要一读取配置文件马上就创建配置文件中配置的对象。
     * BeanFactory： 对于需要创建对个对象使用这种方式（多例模式）
     *          他在构建核心容器时，创建对象采用的策略时延迟加载的方式，也就是说，什么时候根据id获取对象，什么时候才真正的创建对象。
     *
     *
      * @param args
     */
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\workinstall\\ideawoekspaces\\itheima\\day01_eesy_03spring\\src\\main\\resources\\bean.xml");
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountDao adao= ac.getBean("accountDao",IAccountDao.class);
//
//        System.err.println(as);
//        System.err.println(adao);
//      ----------------------------BeanFactory----
//       这个方法虽然已经没有用，但是这里只是作为一个例子，来使用    -----------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");
        System.err.println(as);







        }
}
