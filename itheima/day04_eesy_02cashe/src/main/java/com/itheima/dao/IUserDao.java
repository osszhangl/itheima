package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 * 用户的持久层用户方法
 * @Date:2021/7/17 11:08
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IUserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id删除用户
     * @return
     */
    User findById(int id);


}
