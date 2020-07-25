import java.sql.*;

/**
 * @ClassName: JDBCTest
 * @Description: JDBC
 * @Author: Ma Yuanyuan
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://locolhost:3306/db_test3";
        String user = "root";
        String password = "";

        try {
            //类加载机制，使静态代码块执行
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            int count = statement.executeUpdate("INSERT INTO student VALUES (10, 10020, '唐7藏', NULL)");
            if(count == 1){
                System.out.println("插入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement == null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection == null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
