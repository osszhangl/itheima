package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceImp;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.factory
 * Description: 模拟一个工厂类，（该类可能存在于jar包中的，
 * 我们无法通过修改源码的方式来提供默认构造函数）
 *
 * @Date:2021/8/8 11:18
 * @Author:zhang'lin zhanglin@163.com
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImp();
    }


}
