package fx.leyu.mysql;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.*;
import java.util.concurrent.TimeUnit;

public class LxfJdbcTransactionReadMain {
    // jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/learnjdbc";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得数据库链接
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        try {
            // Connection.TRANSACTION_READ_COMMITTED 读到已提交的数据
            // Connection.TRANSACTION_READ_UNCOMMITTED 读到另外的事物未提交的数据
            // Connection.TRANSACTION_REPEATABLE_READ 可以重复读
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            conn.setAutoCommit(false);
            select(conn);

            System.out.println("-------------");
            TimeUnit.SECONDS.sleep(10);
            update(conn);
            select(conn);
        } catch (SQLException | InterruptedException throwable) {
            conn.rollback();
            throwable.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    private static void update(Connection conn) throws SQLException {
        String sql = "UPDATE students SET name=? WHERE name=?;";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setObject(1, "fxleyu");
            statement.setObject(2, "Bob");
            statement.executeUpdate();
        }
    }

    private static void select(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students;";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "," + rs.getString(2));
                }
            }
        }
    }
}
