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
public class User2 implements Serializable {
    private Integer myId;
    private String myName;
    private String myAddress;
    private String mySex;
    private Date myBirthday;

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    public String getMySex() {
        return mySex;
    }

    public void setMySex(String mySex) {
        this.mySex = mySex;
    }

    public Date getMyBirthday() {
        return myBirthday;
    }

    public void setMyBirthday(Date myBirthday) {
        this.myBirthday = myBirthday;
    }

    @Override
    public String toString() {
        return "User2{" +
                "myId=" + myId +
                ", myName='" + myName + '\'' +
                ", myAddress='" + myAddress + '\'' +
                ", mySex='" + mySex + '\'' +
                ", myBirthday=" + myBirthday +
                '}';
    }
}
