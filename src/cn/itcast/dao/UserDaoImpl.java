package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class UserDaoImpl implements UserDao{
    //获取操作数据库的Template方法
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<User> findAll() {
        //定义sql语句
        String sql = "select * from user";
        //执行sql
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username,String password) {
        //防止没有找到
        try {
            //定义sql语句
            String sql = "select * from user where username=? and password = ?";
            //执行sql
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
