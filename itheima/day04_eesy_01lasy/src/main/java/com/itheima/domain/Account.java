package com.itheima.domain;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 * 账号实体类
 * @Date:2021/7/20 23:41
 * @Author:zhang'lin zhanglin@163.com
 */
public class Account {

    private Integer id;
    private Integer uid;
    private Double money;

    private User user;//关联用户表的实体封装类，

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Integer getAid() {
        return id;
    }

    public void setAid(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
