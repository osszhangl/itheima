package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.imp
 * Description: 用于优化方法之间调用的耦合性
 *
 * @Date:2021/7/26 20:36
 * @Author:zhang'lin zhanglin@163.com
 */

public class AccountServiceImp implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
            return  accountDao.findAll();

    }

    public Account findAccountById(Integer accountId) {
            return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
            accountDao.saveAccount(account);

    }

    public void updateAccount(Account account) {
            accountDao.updateAccount(account);

    }

    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);

    }

    public void tranfer(String sourceName, String targetName, Float money) {
        System.out.println("tranfer....");
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
//            int i=1/0;
            //2.6、更新转入账户
            accountDao.updateAccount(target);

    }
}
