package com.itheima.dao;


import com.itheima.domain.User1;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 * 用户的持久层用户方法
 * @Date:2021/7/17 11:08
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IUser1Dao {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select *  from user")
    @Results(id="resultUser",
            value = {
            @Result(id=true,property = "uId",column = "id"),
            @Result(property = "userName",column = "username"),
            @Result(property = "userAddress",column = "address"),
            @Result(property = "userSex",column = "sex"),
            @Result(property = "userBirthday",column = "birthday")
            })
    List<User1> findAll();

    /**
     * 根据id用户
     * @return
     */
    @Select("select *  from user where id=#{id}")
    @ResultMap(value = "resultUser")//@ResultMap这里可以是value=“resultUser” 或者直接“resultUser”
    User1 findById(int id);


    /**
     * 根据名字模糊查询
     * @param username
     * @return
     */
    @ResultMap("resultUser")
    @Select("select * from user where username like #{username}")
//    @Select("select * from user where username like %${username}%")
    List<User1> fandByName(String username);

    /**
     * 查询用户总数
     * @return
     */
    @Select("select count(*) from user")
    int findCount();



}
