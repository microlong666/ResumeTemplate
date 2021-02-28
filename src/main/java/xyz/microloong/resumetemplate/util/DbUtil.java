package xyz.microloong.resumetemplate.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@PropertySource("classpath:application.properties")
public class DbUtil {

    private static String driver;

    private static String url;

    private static String user;

    private static String password;

    @Value("${spring.datasource.driver-class-name}")
    public void setDriver(String driver) {
        DbUtil.driver = driver;
    }

    @Value("${spring.datasource.url}")
    public void setUrl(String url) {
        DbUtil.url = url;
    }

    @Value("${spring.datasource.username}")
    public void setUser(String user) {
        DbUtil.user = user;
    }

    @Value("${spring.datasource.password}")
    public void setPassword(String password) {
        DbUtil.password = password;
    }

    /**
     * 用于链接数据库，得到的结果是数据库的连接对象，链接对象具备了操作数据库的很多功能。=
     *
     * @return 链接对象
     */
    public static Connection getConn() {
        //1.    加载数据库驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.    获取数据库链接
        try {
            //3.    将链接返回给工具的使用者
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 断开数据库资源的链接，用于释放资源
     *
     * @param conn      要释放链接
     * @param statement 要释放的执行环境
     * @param resultSet 要释放的结果集
     */
    public static void close(Connection conn, Statement statement, ResultSet resultSet) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
