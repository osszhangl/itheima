package com.itheima.domain;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 *  用来分装多表关联时的结果的封装，但是这种方式比较少用，平常一般不用因为要新建类比较麻烦。
 * @Date:2021/7/24 9:11
 * @Author:zhang'lin zhanglin@163.com
 */
public class AccountUser extends Account
{
    private String username;
    private String address;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +"      AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
