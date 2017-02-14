package com.billzhonggz.controllers;

import com.DavidYao.MySQLAccess;
import com.billzhonggz.DBDemo.DBHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ZHONG on 2016/10/16.
 */
@WebServlet(name = "ShowCourseDetail")
public class ShowCourseDetail extends HttpServlet {
    private com.DavidYao.MySQLAccess DBA;

    public void init() throws ServletException{
        DBA = new MySQLAccess();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_c_id = request.getParameter("c_id");
        if (s_c_id == null)
            s_c_id = (String)request.getAttribute("c_id");
        int c_id = Integer.parseInt(s_c_id);
        String c_code = null;
        String c_name = null;
        Connection conn = DBHelper.connetDB();
        //Search basic info.
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSearchCourse = "SELECT * FROM Course WHERE C_ID = ?";
        try {
            ps = conn.prepareStatement(sqlSearchCourse);
            ps.setInt(1,c_id);
            rs = ps.executeQuery();
            while (rs.next())
            {
                c_code = rs.getString("C_Code");
                c_name = rs.getString("C_Name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Search Cilos.
        ArrayList<HashMap<String,String>> ciloInfo = new ArrayList<>();
        try {
            ciloInfo = DBA.readCiloByC_ID(c_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ciloInfo);

        //Search assessments.
        ArrayList<HashMap<String,String>> assInfo = new ArrayList<>();
        try {
            assInfo = DBA.readAssessmentByC_ID(c_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(assInfo);

        //Return valus and call jsp.
        String message = null;
        if (c_code.equals(null))
            message = "Operation failed.";
        else
        {
            message = "Operation succeed.";
            request.setAttribute("c_name",c_name);
            request.setAttribute("c_code",c_code);
            request.setAttribute("c_id",c_id);
            request.setAttribute("c_t_id","1");
            request.setAttribute("ciloInfo",ciloInfo);
            request.setAttribute("assInfo",assInfo);
        }
        DBHelper.closeDB();
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/viewCourse.jsp");
        rd.forward(request,response);
    }
}
