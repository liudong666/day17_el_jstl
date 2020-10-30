package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;
import cn.itcast.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        List<User> users = dao.findAll();
        return users;
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());


        /*//调用login_dao方法
        UserDao userDao = new UserDaoImpl();
        //通过管理员登录
        User login = userDao.login(user.getUsername(),user.getPassword());
        return login;*/
    }
}
