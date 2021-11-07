package com.itheima.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 *
 * @Date:2021/8/8 16:09
 * @Author:zhang'lin zhanglin@163.com
 */

public class Account {

    private Integer id;
    private String name;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
