package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.utils
 * Description:链接的工具类，他用于从数据库中获取一个链接，并且实现和线程的绑定
 *
 * @Date:2021/9/2 10:57
 * @Author:zhang'lin zhanglin@163.com
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的链接
     * @return
     */
    public Connection getThreadConnection(){
        //1、先从ThreadLocal上获取链接
        Connection conn=tl.get();
        //2、判断当前线程上是否有链接
        try{
        if (conn==null){
            //3、从数据源中获取一个链接，并且存入ThreadLocal中
            conn=dataSource.getConnection();
            tl.set(conn);
        }
        //4、返回当前线程上的链接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把链接和线程解绑
     */
    public void removeConnection(){
        tl.remove();

    }

}
