package fx.leyu.mysql;

import java.sql.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static javafx.beans.binding.Bindings.select;

/**
 * @author fxleyu
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1321748500840481
 */
public class LxfJdbcTransactionMain {
    // jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/learnjdbc";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得数据库链接
        // 自动关闭资源
        Connection connection = null;
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            connection = conn;
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            insert(conn);
            //select(conn);
            //delete(conn);

            conn.commit();
        } catch (Exception throwable) {
            try {
                if (Objects.nonNull(connection)) {
                    connection.rollback();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            throwable.printStackTrace();
        } finally {

        }
    }

    private static void insert(Connection conn) throws SQLException{
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
    }

    private static void select(Connection conn) throws IllegalAccessException, InterruptedException, SQLException {
        String sql = "SELECT * FROM students;";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // 4.处理数据库的返回结果(使用ResultSet类)
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        }
        TimeUnit.SECONDS.sleep(30);
        throw new IllegalAccessException();
    }

    private static void delete(Connection conn)  throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
            ps.setObject(1, 1000);
            int n = ps.executeUpdate();
            System.out.println("DELETE id = " + n);
        }
    }
}
