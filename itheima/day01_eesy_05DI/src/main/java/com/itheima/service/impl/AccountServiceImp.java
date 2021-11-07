package com.itheima.service.impl;
import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.service.impl
 * Description:
 *
 * @Date:2021/7/26 20:36
 * @Author:zhang'lin zhanglin@163.com
 */
public class AccountServiceImp implements IAccountService {
    //如果是经常变化的数据，不适合用注入的方式
    private String userName;
    private Integer age;
    private Date birthday;

    public AccountServiceImp(String userName, Integer age, Date birthday) {
        this.userName = userName;
        this.age = age;
        this.birthday = birthday;
    }

    
    public void saveAccount() {
        System.err.println("service中的saveAccount方法执行了。。。。"+userName +","+age+","+birthday);
    }
}
