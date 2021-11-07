package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 *  用于测试实体类的属性和表的类名不一致，mybatis注解方式
 * @Date:2021/7/17 10:33
 * @Author:zhang'lin zhanglin@163.com
 */
public class User1 implements Serializable {
    private Integer uId;
    private String userName;
    private String userAddress;
    private String userSex;
    private Date userBirthday;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                '}';
    }
}
