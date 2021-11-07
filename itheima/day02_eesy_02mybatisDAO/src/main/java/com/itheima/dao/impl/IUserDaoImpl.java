package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * ClassNamezhang'lin
 * PackageName:com.itheima.dao.impl
 * Description:
 *
 * @Date:2021/7/18 9:49
 * @Author:zhang'lin zhanglin@163.com
 */
public class IUserDaoImpl implements IUserDao {

    private SqlSession session;

    /**
     * 通过构造方法获取SqlSessionFactory对象来，创建SqlSession对象
     * @param factory
     */
    public  IUserDaoImpl(SqlSessionFactory factory){
        session =factory.openSession();
    }


    public List<User> findAll() {
        //通过指定这个命名空间+ 方法id来确认，mapper中对应的sql
        List<User> users=session.selectList("com.itheima.dao.IUserDao.findAll");
        session.commit();
        session.close();
        return users;
    }

    public User findById(int id) {

        User user= session.selectOne("com.itheima.dao.IUserDao.findById",id);
        session.close();
        return  user;
    }

    public void save(User user) {
        session.insert("com.itheima.dao.IUserDao.save",user);
        session.commit();
        session.close();

    }

    public void updateUser(User user) {
        session.update("com.itheima.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer id) {
        session.delete("com.itheima.dao.IUserDao.deleteUser",id);
        session.commit();
        session.close();
    }

    public List<User> fandByName(String username) {
        List<User> users=session.selectList("com.itheima.dao.IUserDao.fandByName",username);
        session.close();
        return users;
    }

    public int findCount() {
        int sum=session.selectOne("com.itheima.dao.IUserDao.findCount");
        return sum;
    }
}
