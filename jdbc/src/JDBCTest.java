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
        ResultSet resultSet= null;
        String url =  "jdbc:mysql://localhost:3306/db_test3?serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            //类加载机制，使静态代码块执行
            Class.forName("com.mysql.jdbc.Driver");
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/test? user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
            statement = connection.createStatement();
//            int count = statement.executeUpdate("INSERT INTO student VALUES (10, 10020, '唐7藏', NULL)");
//            if(count == 1){
//                System.out.println("插入成功");
//            }
            resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                int sn = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String mail = resultSet.getString(4);
                System.out.println(id + "," + sn +"," + name +"," +mail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultSet == null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                resultSet = null;
            }
            try {
                if(statement == null){
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                statement = null;
            }
            try {
                if(connection == null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection = null;
            }
        }
    }
}
