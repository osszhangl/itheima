package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao
 * Description:
 *
 * @Date:2021/7/24 14:51
 * @Author:zhang'lin zhanglin@163.com
 */
public interface IRoleDao {

    /**
     * 查询所有角色信息
     * @return
     */
    List<Role> findAll();


}
