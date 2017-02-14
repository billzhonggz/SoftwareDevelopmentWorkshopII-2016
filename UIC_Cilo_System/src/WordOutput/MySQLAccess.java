package WordOutput;

/**
 * Created by ZHONG on 2016/10/23.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MySQLAccess {

    private final static String URL = "jdbc:mysql://localhost:3306/project";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "";
    public final static String DRIVER = "com.mysql.jdbc.Driver";


    public static String select(int a) {
        ResultSet result = null;
        String output = "";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM content WHERE qpid = '" + a + "' ";
            Statement state = connection.createStatement();
            result = state.executeQuery(sql);

            while (result.next()) {
                output = output + result.getString("contentid") + "." + result.getString("content") + "\r";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public ArrayList<HashMap<String,String>> readCILOPercentageByCID (int C_ID){
        ArrayList<HashMap<String,String>> CI_IDs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<HashMap<String,String>> percentage = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //Find CI_IDs.
            ps = connection.prepareStatement("SELECT `CI_ID` FROM `uic_cilo_system`.`C_CI` WHERE `C_ID` = ?)");
            ps.setInt(1, C_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("CI_ID", rs.getString("CI_ID"));
                CI_IDs.add(row);
            }
            //Calculate percentages of each CILO.
            ps = connection.prepareStatement("SELECT SUM(Percentage) AS sumPer FROM A_Q WHERE Q_ID IN (SELECT Q_ID FROM Q_CI WHERE CI_ID = ?)");
            HashMap<String,String> row = null;
            HashMap<String,String> rowCI_ID = null;
            for (int i = 0; i < CI_IDs.size(); i++)
            {
                rowCI_ID = CI_IDs.get(i);
                ps.setInt(1,Integer.parseInt(rowCI_ID.get("CI_ID")));
                rs = ps.executeQuery();
                while (rs.next()){

                    row.put("sumPer",rs.getString("sumPer"));
                    percentage.add(row);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return percentage;
    }
}