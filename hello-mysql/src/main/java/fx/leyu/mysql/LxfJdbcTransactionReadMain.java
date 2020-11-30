package fx.leyu.mysql;

import java.sql.*;

public class LxfJdbcTransactionReadMain {
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
            // Connection.TRANSACTION_READ_COMMITTED 读到已提交的数据
            // (Connection.TRANSACTION_READ_UNCOMMITTED 读到另外的事物未提交的数据
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            //conn.setAutoCommit(false);
            String sql = "SELECT * FROM students;";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString(1));
                    }
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
