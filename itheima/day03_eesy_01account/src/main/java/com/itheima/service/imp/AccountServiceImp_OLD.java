package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.imp
 * Description: 这个类不是最佳的使用方式（这百年方法之间的耦合太高了），在AccountServiceImp类中有优化
 *
 * @Date:2021/7/26 20:36
 * @Author:zhang'lin zhanglin@163.com
 */

public class AccountServiceImp_OLD implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        try{
            //1、开启事务
            txManager.beginTransation();
            //2、执行操作
            List<Account> accounts =  accountDao.findAll();
            //3、提交事务
            txManager.commitTransation();
            //4、返回结果
            return accounts;
        }catch (Exception e){
            //5、回滚操纵
            txManager.roballTransation();
            throw  new RuntimeException(e);
        }finally {
            //6、释放链接
            txManager.releaseTransation();
        }

    }

    public Account findAccountById(Integer accountId) {
        try{
            //1、开启事务
            txManager.beginTransation();
            //2、执行操作
            Account account = accountDao.findAccountById(accountId);
            //3、提交事务
            txManager.commitTransation();
            //4、返回结果
            return account;
        }catch (Exception e){
            //5、回滚操纵
            txManager.roballTransation();
            throw  new RuntimeException(e);
        }finally {
            //6、释放链接
            txManager.releaseTransation();
        }
    }

    public void saveAccount(Account account) {
        try{
            //1、开启事务
            txManager.beginTransation();
            //2、执行操作
            accountDao.saveAccount(account);
            //3、提交事务
            txManager.commitTransation();
        }catch (Exception e){
            //5、回滚操纵
            txManager.roballTransation();
        }finally {
            //6、释放链接
            txManager.releaseTransation();
        }

    }

    public void updateAccount(Account account) {
        try{
            //1、开启事务
            txManager.beginTransation();
            //2、执行操作
            accountDao.updateAccount(account);
            //3、提交事务
            txManager.commitTransation();
        }catch (Exception e){
            //5、回滚操纵
            txManager.roballTransation();
        }finally {
            //6、释放链接
            txManager.releaseTransation();
        }

    }

    public void deleteAccount(Integer accountId) {
        try{
            //1、开启事务
            txManager.beginTransation();
            //2、执行操作
            accountDao.deleteAccount(accountId);
            //3、提交事务
            txManager.commitTransation();
        }catch (Exception e){
            //5、回滚操纵
            txManager.roballTransation();
        }finally {
            //6、释放链接
            txManager.releaseTransation();
        }

    }

    public void tranfer(String sourceName, String targetName, Float money) {
        try{
            //1、开启事务
            txManager.beginTransation();
            //2、执行操作
            //2.1、根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2、根据名称查出转如账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3、转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4、转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5、更新转出账户
            accountDao.updateAccount(source);
            int i=1/0;
            //2.6、更新转入账户
            accountDao.updateAccount(target);
            //3、提交事务
            txManager.commitTransation();
        }catch (Exception e){
            //5、回滚操纵
            txManager.roballTransation();
            e.printStackTrace();
        }finally {
            //6、释放链接
            txManager.releaseTransation();
        }


    }
}
