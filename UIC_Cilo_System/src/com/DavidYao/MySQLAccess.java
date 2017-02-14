package com.DavidYao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.jdbc2.optional.ConnectionWrapper;


public class MySQLAccess {
    private final static String URL = "jdbc:mysql://test.billzhonggz.com:3306/uic_cilo_system";
    private final static String USERNAME = "cilo";
    private final static String PASSWORD = "2016workshop2";
    private final static String DRIVER= "com.mysql.jdbc.Driver";

    private PreparedStatement ps = null;
    private Statement s = null;
    private ResultSet rs = null;
    private Connection connection = null;
    //EditAssessment page
    //Print Info
    public ArrayList<HashMap<String, String>> readAssessmentByA_ID(int A_ID) throws Exception{
        try {
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            ps = connection.prepareStatement("SELECT `A_Name`, `A_Type`, `Percentage` FROM `uic_cilo_system`.`Assessment` WHERE `A_ID` = ?");
            ps.setInt(1, A_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("A_Name", rs.getString("A_Name"));
                row.put("A_Type", rs.getString("A_Type"));
                row.put("Percentage", rs.getString("Percentage"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public ArrayList<HashMap<String, String>> readAssessmentByC_ID(int C_ID) throws Exception{
        try {
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            ps = connection.prepareStatement("SELECT `A_ID`, `A_Name`, `A_Type`, `Percentage` FROM `uic_cilo_system`.`Assessment` WHERE `A_ID` IN (SELECT A_ID FROM C_A WHERE C_ID = ?)");
            ps.setInt(1, C_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("A_Name", rs.getString("A_Name"));
                row.put("A_Type", rs.getString("A_Type"));
                row.put("Percentage", rs.getString("Percentage"));
                row.put("A_ID",rs.getString("A_ID"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public ArrayList<HashMap<String, String>> readCiloByC_ID(int C_ID) throws Exception{
        try {
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            ps = connection.prepareStatement("SELECT * FROM `uic_cilo_system`.`CILO` WHERE `CI_ID` IN (SELECT `CI_ID` FROM `uic_cilo_system`.`C_CI` WHERE `C_ID` = ?)");
            ps.setInt(1, C_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("CI_ID", rs.getString("CI_ID"));
                row.put("CI_Description", rs.getString("CI_Description"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    public ArrayList<HashMap<String, String>> readA_QByA_IDQ_Number(int A_ID, int Q_Number) throws Exception{
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        try{
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            ps = connection.prepareStatement("SELECT `Q_ID`, `Percentage` FROM `uic_cilo_system`.`A_Q` WHERE `A_ID` = ? AND `Q_Number` = ?");
            ps.setInt(1, A_ID);
            ps.setInt(2, Q_Number);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("Q_ID", rs.getString("Q_ID"));
                row.put("Percentage", rs.getString("Percentage"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    public ArrayList<HashMap<String, String>> readQuestionByQ_ID(int Q_ID) throws Exception{
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        try{
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            ps = connection.prepareStatement("SELECT `Q_Description`, `picUrl` FROM `uic_cilo_system`.`Question` WHERE `Q_ID` = ?");
            ps.setInt(1, Q_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("Q_Description", rs.getString("Q_Description"));
                row.put("picUrl", rs.getString("picUrl"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    public ArrayList<HashMap<String, String>> readCogLevelByQ_ID(int Q_ID) throws Exception{
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        try{
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            ps = connection.prepareStatement("SELECT `cogLevel` FROM `uic_cilo_system`.`cogLevel` WHERE `Q_ID` = ?");
            ps.setInt(1, Q_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("cogLevel", rs.getString("cogLevel"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    public ArrayList<HashMap<String, String>> readQ_CIByQ_ID(int Q_ID) throws Exception{
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        try{
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
            ps = connection.prepareStatement("SELECT `CI_ID` FROM `uic_cilo_system`.`Q_CI` WHERE `Q_ID` = ?");
            ps.setInt(1, Q_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("CI_ID", rs.getString("CI_ID"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    //Delete Question
    public void deleteQuestion(int Q_ID, int A_ID) throws Exception{
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            int Q_Number = 0;
            int mQ_Number = 0;

            ps = connection.prepareStatement("DELETE FROM `uic_cilo_system`.`Question` WHERE `Q_ID` = ?");
            ps.setInt(1, Q_ID);
            ps.executeUpdate();

            ps = connection.prepareStatement("DELETE FROM `uic_cilo_system`.`Q_CI` WHERE `Q_ID` = ?");
            ps.setInt(1, Q_ID);
            ps.executeUpdate();

            ps = connection.prepareStatement("DELETE FROM `uic_cilo_system`.`cogLevel` WHERE `Q_ID` = ?");
            ps.setInt(1, Q_ID);
            ps.executeUpdate();

            mQ_Number = readMQ_Number(A_ID);

            ps = connection.prepareStatement("SELECT `Q_Number` FROM `uic_cilo_system`.`A_Q` WHERE `Q_ID` = ? AND `A_ID` =?");
            ps.setInt(1, Q_ID);
            ps.setInt(2, A_ID);
            rs = ps.executeQuery();
            while(rs.next())
                Q_Number = Integer.parseInt(rs.getString(1));

            if(Q_Number == mQ_Number){
                ps = connection.prepareStatement("DELETE FROM `uic_cilo_system`.`A_Q` WHERE `Q_Number` = ? AND `A_ID` = ?");
                ps.setInt(1, Q_Number);
                ps.setInt(2, A_ID);
                ps.executeUpdate();
            }
            else{
                int rQ_ID = 0;
                int wQ_ID = 0;
                int rPercentage = 0;
                int wPercentage = 0;
                ps = connection.prepareStatement("SELECT `Q_ID`, `Percentage` FROM `uic_cilo_system`.`A_Q` WHERE `Q_Number` = ? AND `A_ID` = ?");
                ps.setInt(1, mQ_Number);
                ps.setInt(1, A_ID);
                rs = ps.executeQuery();
                while(rs.next()){
                    wQ_ID = Integer.parseInt(rs.getString(1));
                    wPercentage = Integer.parseInt(rs.getString(2));
                }

                ps = connection.prepareStatement("DELETE FROM `uic_cilo_system`.`A_Q` WHERE `Q_Number` = ? AND `A_ID` = ?");
                ps.setInt(1, mQ_Number);
                ps.setInt(2, A_ID);
                ps.executeUpdate();

                for(int i = mQ_Number - 1; i > Q_Number; i--){
                    ps = connection.prepareStatement("SELECT `Q_ID`, `Percentage` FROM `uic_cilo_system`.`A_Q` WHERE `Q_Number` = ? AND `A_ID` = ?");
                    ps.setInt(1, i);
                    ps.setInt(2, A_ID);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        rQ_ID = Integer.parseInt(rs.getString(1));
                        rPercentage = Integer.parseInt(rs.getString(2));
                    }

                    ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`A_Q` SET `Q_ID` = ?, `Percentage` = ? WHERE `Q_Number` = ? AND `A_ID` = ?");
                    ps.setInt(1, wQ_ID);
                    ps.setInt(2, wPercentage);
                    ps.setInt(3, i);
                    ps.setInt(4, A_ID);
                    ps.executeUpdate();

                    wQ_ID = rQ_ID;
                    wPercentage = rPercentage;
                }

                ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`A_Q` SET `Q_ID` = ?, `Percentage` = ? WHERE `Q_Number` = ? AND `A_ID` = ?");
                ps.setInt(1, wQ_ID);
                ps.setInt(2, wPercentage);
                ps.setInt(3, Q_Number);
                ps.setInt(4, A_ID);
                ps.executeUpdate();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    //EditQuestion Page
    //Get mQ_Number
    public int readMQ_Number(int A_ID) throws Exception{
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            ps = connection.prepareStatement("SELECT MAX(`Q_Number`) FROM `uic_cilo_system`.`A_Q` WHERE `A_ID` = ?");
            ps.setInt(1, A_ID);
            rs = ps.executeQuery();
            while(rs.next())
                return Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return 0;
    }
    //Get CI_ID
    public ArrayList<HashMap<String, String>> readCI_ID(int C_ID) throws Exception{
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            ArrayList<HashMap<String, String>> alrs = new ArrayList<>();

            ps = connection.prepareStatement("SELECT `CI_ID` FROM `uic_cilo_system`.`C_CI` WHERE `C_ID` = ?");
            ps.setInt(1, C_ID);
            rs = ps.executeQuery();

            while(rs.next()){
                HashMap<String, String> row = new HashMap<>();
                row.put("CI_ID", rs.getString("CI_ID"));
                alrs.add(row);
            }
            return alrs;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    //Edit Question
    public void editQuestion(int Q_ID, String Q_Description, String picUrl, int A_ID, int Q_Number, int Percentage, String cogLevel, int CI_ID) throws Exception{
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            int cQ_Number = 0;

            ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`Question` SET `Q_Description` = ?, `picUrl` = ? WHERE `Q_ID` = ?");
            ps.setString(1, Q_Description);
            ps.setString(2, picUrl);
            ps.setInt(3, Q_ID);
            ps.executeUpdate();

            ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`cogLevel` SET `cogLevel` = ? WHERE `Q_ID` = ?");
            ps.setString(1, cogLevel);
            ps.setInt(2, Q_ID);
            ps.executeUpdate();

            ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`Q_CI` SET `CI_ID` = ? WHERE `Q_ID` = ?");
            ps.setInt(1, CI_ID);
            ps.setInt(2, Q_ID);
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT `Q_Number` FROM `uic_cilo_system`.`A_Q` WHERE `A_ID` = ? AND `Q_ID` = ?");
            ps.setInt(1, A_ID);
            ps.setInt(2, Q_ID);
            rs = ps.executeQuery();
            while(rs.next())
                cQ_Number = Integer.parseInt(rs.getString(1));

            if(cQ_Number != Q_Number){
                int Q_ID1 = Q_ID;
                int Percentage1 = 0;
                int Q_ID2 = 0;
                int Percentage2 = 0;
                ps = connection.prepareStatement("SELECT `Percentage` FROM `uic_cilo_system`.`A_Q` WHERE `A_ID` = ? AND `Q_Number` = ?");
                ps.setInt(1, A_ID);
                ps.setInt(2, cQ_Number);
                rs = ps.executeQuery();
                while(rs.next())
                    Percentage1 = Integer.parseInt(rs.getString(1));

                ps = connection.prepareStatement("SELECT `Q_ID`, `Percentage` FROM `uic_cilo_system`.`A_Q` WHERE `A_ID` = ? AND `Q_Number` = ?");
                ps.setInt(1, A_ID);
                ps.setInt(2, Q_Number);
                rs = ps.executeQuery();
                while(rs.next()){
                    Q_ID2 = Integer.parseInt(rs.getString(1));
                    Percentage2 = Integer.parseInt(rs.getString(2));
                }

                ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`A_Q` SET `Q_ID` = ?, Percentage = ? WHERE `A_ID` = ? AND `Q_Number` = ?");
                ps.setInt(1, Q_ID2);
                ps.setInt(2, Percentage2);
                ps.setInt(3, A_ID);
                ps.setInt(4, cQ_Number);
                ps.executeUpdate();

                ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`A_Q` SET `Q_ID` = ?, Percentage = ? WHERE `A_ID` = ? AND `Q_Number` = ?");
                ps.setInt(1, Q_ID1);
                ps.setInt(2, Percentage1);
                ps.setInt(3, A_ID);
                ps.setInt(4, Q_Number);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    //AddQuestion Page
    public void writeQuestion(String Q_Description, String picUrl, int A_ID, int Q_Number, int Percentage, String cogLevel, int CI_ID) throws Exception{
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            int Q_ID = 0;
            int mQ_Number = 0;

            ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`Question` (`Q_ID`, `Q_Description`, `picUrl`) VALUES (NULL, ?, ?)");
            ps.setString(1, Q_Description);
            ps.setString(2, picUrl);
            ps.executeUpdate();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT MAX(`Q_ID`) FROM `uic_cilo_system`.`Question`");
            while(rs.next())
                Q_ID = Integer.parseInt(rs.getString(1));

            s = connection.createStatement();
            rs = s.executeQuery("SELECT MAX(`Q_Number`) FROM `uic_cilo_system`.`A_Q` WHERE `A_ID` = "+A_ID+" GROUP BY `A_ID` ");
            while(rs.next())
                mQ_Number = Integer.parseInt(rs.getString(1));
            if(Q_Number <= mQ_Number){
                int t1Q_ID = Q_ID;
                int t1Percentage = Percentage;
                int t2Q_ID = 0;
                int t2Percentage = 0;

                for(int i = Q_Number; i <= Q_Number; i++){
                    ps = connection.prepareStatement("SELECT `Q_ID`, `Percentage` FROM `uic_cilo_system`.`A_Q` WHERE `Q_Number` = ? AND `A_ID` = ?");
                    ps.setInt(1, i);
                    ps.setInt(2, A_ID);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        t2Q_ID = Integer.parseInt(rs.getString(1));
                        t2Percentage = Integer.parseInt(rs.getString(2));
                    }

                    ps = connection.prepareStatement("UPDATE `uic_cilo_system`.`A_Q` SET `Q_ID` = ?, `Percentage` = ? WHERE `Q_Number` = ? AND `A_ID` = ?");
                    ps.setInt(1, t1Q_ID);
                    ps.setInt(2, t1Percentage);
                    ps.setInt(3, i);
                    ps.setInt(4, A_ID);
                    ps.executeUpdate();

                    t1Q_ID = t2Q_ID;
                    t1Percentage = t2Percentage;
                }
                ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`A_Q` (`Q_ID`, `A_ID`, `Q_Number`, `Percentage`) VALUES (?, ?, ?, ?)");
                ps.setInt(1, t1Q_ID);
                ps.setInt(2, A_ID);
                ps.setInt(3, mQ_Number+1);
                ps.setInt(4, t1Percentage);
                ps.executeUpdate();

            }
            else{
                ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`A_Q` (`Q_ID`, `A_ID`, `Q_Number`, `Percentage`) VALUES (?, ?, ?, ?)");
                ps.setInt(1, Q_ID);
                ps.setInt(2, A_ID);
                ps.setInt(3, Q_Number);
                ps.setInt(4, Percentage);
                ps.executeUpdate();
            }

            ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`cogLevel` (`Q_ID`, `cogLevel`) VALUES (?, ?)");
            ps.setInt(1, Q_ID);
            ps.setString(2, cogLevel);
            ps.executeUpdate();

            ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`Q_CI` (`Q_ID`, `CI_ID`) VALUES (?, ?)");
            ps.setInt(1, Q_ID);
            ps.setInt(2, CI_ID);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    //AddAssessment Page
    public void writeAssessment(int C_ID, String A_Name, String A_type, int Percentage) throws Exception{
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName(DRIVER);
            // Setup the connection with the DB
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            int A_ID = 0;

            ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`Assessment` (`A_ID`, `A_Name`, `A_Type`, `Percentage`) VALUES (NULL, ?, ?, ?)");
            ps.setString(1, A_Name);
            ps.setString(2, A_type);
            ps.setInt(3, Percentage);
            ps.executeUpdate();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT MAX(`A_ID`) FROM `uic_cilo_system`.`Assessment`");
            while(rs.next())
                A_ID = Integer.parseInt(rs.getString(1));

            ps = connection.prepareStatement("INSERT INTO `uic_cilo_system`.`C_A` (`A_ID`, `C_ID`) VALUES (?, ?)");
            ps.setInt(1, A_ID);
            ps.setInt(2, C_ID);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    private void close() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (s != null) {
                s.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }

}