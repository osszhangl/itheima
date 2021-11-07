package com.itheima.dao.iml;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

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

    public void save() {

        System.err.println("保存成功");
    }
}
