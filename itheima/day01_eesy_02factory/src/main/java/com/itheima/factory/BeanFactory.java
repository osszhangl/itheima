package com.itheima.factory;

import javax.lang.model.element.Element;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.factory
 * Description:
 * bean工厂
 * bean在计算机英语中，有可重用组件的含义
 * javaBean：用java语言编写的可重用组件
 * javabean >= 实体类
 * 这个类就创建我们的service和dao的对象的
 * 第一个：需要一个配置文件来配置我们的service和dao
 * 配置额内容，唯一标识 = 全限定类名（key=value的形式）
 * 我们的配置文件可以时xml也可以时properties
 * <p>
 * 第二个：通过读取配置文件中的配置内容，，反射创建对象
 *
 * @Date:2021/7/26 20:53
 * @Author:zhang'lin zhanglin@163.com
 */
public class BeanFactory {

    private static Properties props;

    //将bean存储在map，容器中
    private static Map<String,Object> beans;

    //使用静态代码快对propertie对象赋值
    static {
        try {
            props = new Properties();
            //这边使用类加载器来加载resource路径下的配置文件，不要使new FileInputStream() 这中方式，因为不论是使用绝对路径还是相对路径对不合适
            //resours下的文件打包部署之后会在类的根路径下，比较好找。
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans= new HashMap<String,Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key=keys.nextElement().toString();
                //根据key获取value
                String beanPath= props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始话properties失败！" + e);
        }
    }

    /**
     * 根据bean的名称获取nean对象
     *
     * @param beanName
     * @return
    */
    public static Object getbean(String beanName) {

    return beans.get(beanName);
    }








    /**
     * 根据bean的名称获取nean对象
     *
     * @param beanName
     * @return

    public static Object getbean(String beanName) {
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            System.err.println(beanPath);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
     */

}
