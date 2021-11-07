package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 * 用户的持久层用户方法
 * @Date:2021/7/17 11:08
 * @Author:zhang'lin zhanglin@163.com
 */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select *  from user")
    @Results(id="resultUser",
    value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "birthday",column = "birthday"),
            //一对多查询，使用延迟加载，FetchType.LAZY
            @Result(property = "accounts",column = "id",many = @Many(select="com.itheima.dao.IAccountDao.findByUid",fetchType= FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id删除用户
     * @return
     */
    @Select("select *  from user where id=#{id}")
    User findById(int id);

    /**
     * 保存数据
     * @param user
     */
    @Insert("insert into user (username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void save(User user);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    /**
     * 根据名字模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
//    @Select("select * from user where username like %${username}%")
    List<User> fandByName(String username);

    /**
     * 查询用户总数
     * @return
     */
    @Select("select count(*) from user")
    int findCount();



}
