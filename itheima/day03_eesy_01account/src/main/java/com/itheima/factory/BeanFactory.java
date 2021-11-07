package com.itheima.factory;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.factory
 * Description:
 *      用于创建service的代理对象工厂
 *
 * @Date:2021/9/2 19:10
 * @Author:zhang'lin zhanglin@163.com
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getiAccountService(){
        IAccountService iAccountService =(IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue=null;
                        //test方法没没有被增强，所以test方法只是一个连接点不是切入点
                        if ("test".equals(method.getName())){
                            return method.invoke(accountService,args);
                        }

                        try{
                            //1、开启事务
                            txManager.beginTransation();
                            //2、执行操作
                            returnValue = method.invoke(accountService,args);
                            //3、提交事务
                            txManager.commitTransation();
                            //4、返回结果
                            return returnValue;
                        }catch (Exception e){
                            //5、回滚操纵
                            txManager.roballTransation();
                            throw  new RuntimeException(e);
                        }finally {
                            //6、释放链接
                            txManager.releaseTransation();
                        }
                    }
                }
        );
        return iAccountService;
    }



}
