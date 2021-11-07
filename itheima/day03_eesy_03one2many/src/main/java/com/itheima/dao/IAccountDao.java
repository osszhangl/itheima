package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 *
 * @Date:2021/7/20 23:40
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IAccountDao {
    /**
     * 查询所有账号
     * @return
     */
    public List<Account> findAll();


    /**
     * 查找所有账户和用户信息，
     * @return
     */
    public List<AccountUser> findAccount();





}
