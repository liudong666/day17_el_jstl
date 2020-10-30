package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    //定义一个返回数据库池
    private static DataSource dataSource;

    //获取配置文件路径链接数据库
    static {
        //加载配置文件
        Properties properties = new Properties();

        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
            //初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接池对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //获取数据库连接池
    public static DataSource getDataSource(){
        return dataSource;
    }
}
