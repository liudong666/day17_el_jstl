package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    //定义一个操作dao的接口
    public abstract List<User> findAll();

    /**
     *
     * @param user
     * @return
     */
    User login(User user);
}
