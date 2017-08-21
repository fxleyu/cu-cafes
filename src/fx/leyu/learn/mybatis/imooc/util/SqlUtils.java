package fx.leyu.learn.mybatis.imooc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {
    public static Connection getDatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                        e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/autoresponder", "root", "fxyuer");
        } catch (SQLException e) {
                        e.printStackTrace();
        }
        return null;
    }
}
