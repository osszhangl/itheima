package com.itheima.service.imp;

import com.itheima.service.IAccountService;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.imp
 * Description:
 *
 * @Date:2021/7/26 20:36
 * @Author:zhang'lin zhanglin@163.com
 */
public class AccountServiceImp implements IAccountService {



    public AccountServiceImp( ){
        System.out.println("AccountServiceImp构造函数");
    }

    public void saveAccount() {
        System.out.println("执行saveAccount方法");
    }public void init() {
        System.out.println("对象初始化了");
    }public void destroy() {
        System.out.println("对象销毁了");
    }
}
