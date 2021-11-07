package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:PACKAGE_NAME
 * Description:
 *  业务层账户信息查询接口
 * @Date:2021/7/26 20:34
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();


    /**
     * 查询一个账户
     * @param accountId
     * @return
     */
    public Account findAccountById(Integer accountId);

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);

    /**
     * 更新账户信息
     * @param account
     */
    public void updateAccount(Account account);

    /**
     * 删除账户信息
     * @param accountId
     */
    public void deleteAccount(Integer accountId);


}
