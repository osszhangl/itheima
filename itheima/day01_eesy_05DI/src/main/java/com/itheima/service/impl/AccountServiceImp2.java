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
public class AccountServiceImp2 implements IAccountService {
    //如果是经常变化的数据，不适合用注入的方式
    private String userName;
    private Integer age;
    private Date birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.err.println("service中的saveAccount方法执行了。。。。"+userName +","+age+","+birthday);
    }
}
