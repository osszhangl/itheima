package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import com.itheima.domain.User1;
import com.itheima.domain.User2;

import javax.jws.soap.SOAPBinding;
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
     * 根据名字模糊查询
     * @param username
     * @return
     */
    List<User> fandByName(String username);


    /**
     * 根据Vo中的条件查询用户
     * @return
     */
    List<User> fandByVo(QueryVo vo);

    /**
     * 根据传入的参数来查询
     * @param user 传入的参数封装在user对象里面
     * @return
     */
    List<User> fandByContition(User user);

    /**
     * 根据vo里面的id集合查询，对应的id的用户数据
     * @param vo
     * @return
     */
    List<User> fandByIds(QueryVo vo);


}
