package com.itheima.domain;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.domain
 * Description:
 *
 * @Date:2021/7/17 19:21
 * @Author:zhang'lin zhanglin@163.com
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
