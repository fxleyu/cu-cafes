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
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/sys";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得数据库链接
        // 自动关闭资源
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）预编译
            String sql = "SELECT * FROM sys.sys_config;";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                // 4.处理数据库的返回结果(使用ResultSet类)
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        System.out.println("have data");
                        System.out.println(rs.getString(1));
                    }
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
