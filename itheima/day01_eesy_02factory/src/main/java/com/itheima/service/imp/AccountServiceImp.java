package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.iml.AccountDaoImp;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.imp
 * Description:
 *
 * @Date:2021/7/26 20:36
 * @Author:zhang'lin zhanglin@163.com
 */
public class AccountServiceImp implements IAccountService {

    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getbean("accountDao");

    @Override
    public void saveAccount() {
        int i = 1;
        iAccountDao.save();
        System.err.println(i);
        i++;
    }
}
