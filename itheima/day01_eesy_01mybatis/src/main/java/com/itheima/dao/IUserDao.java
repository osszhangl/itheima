package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:PACKAGE_NAME
 * Description:
 *
 * @Date:2021/7/11 12:10
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * 用户的持久层接口
     *
     */
    List<User> findAll();

}
