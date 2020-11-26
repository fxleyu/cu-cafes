package fx.leyu.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fxleyu
 */
public class Main {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://127.0.0.1:3306/sys";
        String USER = "root";
        String PASSWORD = "12345678";
        try {
            // 1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获得数据库链接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）预编译
            String sql = "SELECT * FROM sys.sys_config;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            // 4.处理数据库的返回结果(使用ResultSet类)
            while (rs.next()) {
                System.out.println("have data");
                System.out.println(rs.getString(1));
            }

            // 关闭资源
            conn.close();
            rs.close();
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
