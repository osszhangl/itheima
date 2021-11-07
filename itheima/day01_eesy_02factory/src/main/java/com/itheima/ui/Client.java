package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceImp;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.ui
 * Description:
 *
 * @Date:2021/7/26 20:48
 * @Author:zhang'lin zhanglin@163.com
 */
public class Client {
    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getbean("accountService");
            System.err.println(as);
            as.saveAccount();
        }
    }
}
