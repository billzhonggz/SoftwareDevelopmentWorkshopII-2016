import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ZHONG on 2016/11/21.
 */
public class DBHelper {
    /**
     * @param args
     */
    // 驱动程序就是之前在classpath中配置的JDBC的驱动程序的JAR 包中
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    // 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
    public static final String DBURL = "jdbc:mysql://localhost:3306/jsp_test";
    // 连接数据库的用户名
    public static final String DBUSER = "test";
    // 连接数据库的密码
    public static final String DBPASS = "111111";

    static Connection conn;

    /**
     * Connect to DB
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection connetDB() {

        // 1、使用CLASS 类加载驱动程序
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }

        return conn;

    }

    /**
     * close DB
     */
    public static void closeDB() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
