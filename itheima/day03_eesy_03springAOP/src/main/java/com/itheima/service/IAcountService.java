package com.itheima.service;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service
 * Description:账户的业务接口
 *
 * @Date:2021/9/12 13:05
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IAcountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     *
     * @return
     */
    int deleteAccount();
}
