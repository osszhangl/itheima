package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import com.itheima.domain.User1;
import com.itheima.domain.User2;

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

    /**
     * 保存数据
     * @param user
     */
    void save(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据名字模糊查询
     * @param username
     * @return
     */
    List<User> fandByName(String username);

    /**
     * 查询用户总数
     * @return
     */
    int findCount();

    /**
     * 根据Vo中的条件查询用户
     * @return
     */
    List<User> fandByVo(QueryVo vo);


    /**
     * 当实体属性名称和数据库表的列明不一致时
     * @return
     */
    List<User2> fandAllUser1();

   // List<User2> fandAllUser2();

}
