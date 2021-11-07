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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的一个结果就返回，如果没有结果就会null
     *          如果结果不止一个就抛出异常
     */
    Account findAccountByName(String accountName);


    void test();//他只是连接点，不是切入点，因为没有被增强




}
