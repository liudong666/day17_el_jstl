package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    //定义操作数据库方法的接口
    public abstract List<User> findAll();

    User findUserByUsernameAndPassword(String username,String password);
}
