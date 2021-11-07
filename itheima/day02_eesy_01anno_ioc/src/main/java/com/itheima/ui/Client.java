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
     *
      * @param args
     */
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//ApplicationConText对象就是srping的容器对象
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\workinstall\\ideawoekspaces\\itheima\\day01_eesy_03spring\\src\\main\\resources\\bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountServiceImp");
        IAccountDao ad = (IAccountDao) ac.getBean("accountDao");
        System.err.println(as);
        ad.save();
//        as.saveAccount();






        }
}
