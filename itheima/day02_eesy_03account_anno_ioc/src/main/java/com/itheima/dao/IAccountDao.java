package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima
 * Description:
 *  account持久层实现接口
 * @Date:2021/7/26 20:40
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IAccountDao {
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
     * @param AccountId
     */
    public void deleteAccount(Integer AccountId);


}
