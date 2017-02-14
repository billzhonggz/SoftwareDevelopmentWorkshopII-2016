package com.billzhonggz.controllers;

import com.billzhonggz.DBDemo.DBHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by ZHONG on 2016/10/16.
 * This class will search instructor's information through T_ID. Returns a RequestDispatcher with information.
 */
@WebServlet(name = "ShowInstructorHome")
public class ShowInstructorHome extends HttpServlet {

    private Object[][] resultSetToObjectArray(ResultSet rs) {
//        Object[][] data = {{1,2},{3,4}}; //Test for CHU SHI HUA object array---worked
        Object[][] data = null;

        try
        {
            rs.last();
            int rows = rs.getRow();
            data = new Object[rows][];
            System.out.println("Rows=" + rows); //Test if the data is right.---Right.
            ResultSetMetaData md = rs.getMetaData();//获取记录集的元数据
            int columnCount = md.getColumnCount();//列数
            System.out.println("Column=" + columnCount);
//            int columnCount=8; //Hard code for test. Will be auto filled.
            rs.first();
            int k = 0;
            do {
                System.out.println("i"+k);
                Object[] row = new Object[columnCount];
                for(int i=0; i<columnCount; i++) {
                    row[i] = rs.getObject(i+1).toString();
                }
                data[k] = row;
                k++;
            }while(rs.next());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        //System.out.println(data[0][0]);
        return data;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t_id = request.getParameter("t_id");
        PreparedStatement ps = null;
        //Initialize result strings.
        ResultSet rs = null;
        String t_name = null;
        String t_position = null;
        String t_department = null;
        Date t_e_date = null;
        //Get DB connection.
        Connection conn = DBHelper.connetDB();
        //Query Instructor basic information.
        String sqlTInfo = "SELECT * FROM Lecturer WHERE T_ID = ?";
        try {
            ps = conn.prepareStatement(sqlTInfo);
            ps.setInt(1,Integer.parseInt(t_id));
            rs = ps.executeQuery();
            while(rs.next())
            {
                t_name = rs.getString("T_Name");
                t_position = rs.getString("Position");
                t_department = rs.getString("Department");
                t_e_date = rs.getDate("E_Date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Query course information.
        String sqlCourse = "SELECT * FROM Course WHERE T_ID = ?";
        //Clear ps and rs.
        ps = null;
        rs = null;
        //Begin query.
        try {
            ps = conn.prepareStatement(sqlCourse);
            ps.setInt(1,Integer.parseInt(t_id));
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object courseReturn[][] = resultSetToObjectArray(rs);
        //Return results.
        String message = null;
        if(t_name.equals(null))
        {
            message = "Query information failed.";
        }
        else
        {
            message = "Query succeed. ";
            request.setAttribute("t_id",t_id);
            request.setAttribute("t_name",t_name);
            request.setAttribute("t_department",t_department);
            request.setAttribute("t_position",t_position);
            request.setAttribute("t_e_date",t_e_date);
            request.setAttribute("courseReturn",courseReturn);
        }
        DBHelper.closeDB();
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/instructorHome.jsp");
        rd.forward(request,response);
    }
}
