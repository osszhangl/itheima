package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 * 用于测试在java的实体类和数据库中的列明不一致时，应该怎么处理
 * @Date:2021/7/17 10:33
 * @Author:zhang'lin zhanglin@163.com
 */
public class User1 implements Serializable {
    private Integer uid;
    private String userName;
    private String userAddress;
    private String userSex;
    private Date userBirthday;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "User1{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }
}
