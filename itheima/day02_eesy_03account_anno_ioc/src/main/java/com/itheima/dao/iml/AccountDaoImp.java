package com.itheima.dao.iml;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao.iml
 * Description:
 *  account的持久层实现类
 * @Date:2021/7/26 20:41
 * @Author:zhang'lin zhanglin@163.com
 */
@Repository("accountDao")
public class AccountDaoImp implements IAccountDao{

    @Autowired
    private QueryRunner runner;


    public List<Account> findAll() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
             runner.update("insert into account(uid,money) values(?,?)",account.getUid(),account.getMoney());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set uid=?,money=? where id=?",account.getUid(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer AccountId) {
        try {
            runner.update("delete from  account where id=?",AccountId);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
