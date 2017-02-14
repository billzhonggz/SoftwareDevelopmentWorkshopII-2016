package upload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ZHONG on 2016/10/19.
 */
public class MySQLAccess
{
    private final static String URL = "jdbc:mysql://test.billzhonggz.com:3306/uic_cilo_system";
    public final static String USERNAME = "cilo";
    public final static String PASSWORD = "2016workshop2";
    public final static String DRIVER = "com.mysql.jdbc.Driver";

    public static void uploadExcel(String sql){
        try
        {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement state = connection.createStatement();

            state.executeUpdate(sql);

            state.close();
            connection.close();

            System.out.println("insert success");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
