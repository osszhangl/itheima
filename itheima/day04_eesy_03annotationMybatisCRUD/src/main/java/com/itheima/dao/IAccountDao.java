package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.AbstractCollection;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 *
 * @Date:2021/7/25 16:44
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IAccountDao {

    /**
     * 查询所有账户信息
     * @return
     */
    @Select("select *  from account")
    @Results(id="resultAccount",
    value = {
            @Result(id=true,property = "aId",column = "id"),
            @Result(property = "uId",column = "uid"),
            @Result(property = "money",column = "money"),
//            这样就可以查询一个账户对应的用户信息，不用像xml那时候，关联查询
            @Result(property = "user",column = "uid",one =@One(select="com.itheima.dao.IUserDao.findById",fetchType= FetchType.EAGER))
    })
    public List<Account> findAll();

    /**
     * 根据id查询账户信息
     * @return
     */
    @Select("select * from account  where uid=#{uid}")
    @ResultMap("resultAccount")
    public List<Account> findByUid(Integer id);






}
