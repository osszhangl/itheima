package com.itheima.utils;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.utils
 * Description:和事务管理相关的工具类，他包含了，开启事务，提交事务，回滚事务和释放连接
 *
 * @Date:2021/9/2 11:39
 * @Author:zhang'lin zhanglin@163.com
 */
public class TransactionManager {
    private ConnectionUtils connectinUtils;
    public void  setConnectinUtils(ConnectionUtils connectinUtils){
        this.connectinUtils=connectinUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransation(){
        try{
            connectinUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commitTransation(){
        try{
            connectinUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 回滚事务
     */
    public void roballTransation(){
        try{
            connectinUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 释放事务
     */
    public void releaseTransation(){
        try{
            connectinUtils.getThreadConnection().close();//将链接还给链接池
            connectinUtils.removeConnection();//解除绑定
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
