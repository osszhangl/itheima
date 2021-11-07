package com.itheima.domain;

import org.apache.ibatis.annotations.Insert;

import java.io.Serializable;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 *
 * @Date:2021/7/25 16:36
 * @Author:zhang'lin zhanglin@163.com
 */
public class Account implements Serializable {
    private Integer aId;
    private Integer uId;
    private Double money;

    //多对一（在mybatis里面认为是一对一）
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aId +
                ", uId=" + uId +
                ", money=" + money +
                '}';
    }
}
