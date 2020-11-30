package fx.leyu.mysql;

import java.sql.*;

/**
 * @author fxleyu
 *
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1255943820274272
 */
public class LxfJdbcMain {
    // jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/learnjdbc";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得数据库链接
        // 自动关闭资源
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）预编译
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (grade, name, gender, score) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                //ps.setObject(1, 999);
                ps.setObject(1, 1);
                ps.setObject(2, "Bob");
                ps.setObject(3, 1);
                ps.setObject(4, 99);
                int n = ps.executeUpdate();
                System.out.println("UPDATE id = " + n);
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        System.out.println("key-id = " + id);
                    }
                }
            }

            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
                ps.setObject(1, "FXLEYU");
                ps.setObject(2, 999);
                int n = ps.executeUpdate();
                System.out.println("UPDATE id = " + n);
            }

            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
                ps.setObject(1, 1000);
                int n = ps.executeUpdate();
                System.out.println("DELETE id = " + n);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
