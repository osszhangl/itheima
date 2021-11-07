package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 *
 * @Date:2021/7/24 14:47
 * @Author:zhang'lin zhanglin@163.com
 */
public class Role implements Serializable {

    private Integer roleId;
    private String roleName;
    private String roleDesc;

    //多对多映射，一个角色用有多个用户
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    //不要在toString的方法中加users，这样会导致封装的时候默认值为null，会出现在users=null，在日志中可以看到，这样转null值给前端不不对的
    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
