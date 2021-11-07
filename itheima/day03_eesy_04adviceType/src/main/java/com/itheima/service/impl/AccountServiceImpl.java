package com.itheima.service.impl;

import com.itheima.service.IAcountService;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.impl
 * Description:账户业务层实现类
 *
 * @Date:2021/9/12 13:10
 * @Author:zhang'lin zhanglin@163.com
 */
public class AccountServiceImpl implements IAcountService {
    public void saveAccount() {
        System.out.println("执行保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
