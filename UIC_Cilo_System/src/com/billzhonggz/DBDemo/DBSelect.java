package com.billzhonggz.DBDemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ZHONG on 2016/10/9.
 */
@WebServlet(name = "DBSelect")
public class DBSelect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get DB connection.
        Connection conn = DBHelper.connetDB();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String s_id = null;
        String a_id = null;
        String q_id = null;
        String percentage = null;

        String sql = "SELECT * FROM Score WHERE s_id = ? limit 1";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"1430003045");
            rs = ps.executeQuery();
            while (rs.next())
            {
                s_id = rs.getString("s_id");
                a_id = rs.getString("a_id");
                q_id = rs.getString("q_id");
                percentage = rs.getString("percentage");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeDB();
        }
        String message = null;
        if (s_id == null)
        {
            message = "Select failed.";
        }
        else
        {
            message = "Select succeed.";
            request.setAttribute("s_id",s_id);
            request.setAttribute("a_id",s_id);
            request.setAttribute("q_id",q_id);
            request.setAttribute("percentage",percentage);
        }
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
