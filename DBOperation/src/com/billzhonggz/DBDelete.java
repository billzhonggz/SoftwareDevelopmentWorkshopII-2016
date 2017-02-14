package com.billzhonggz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by ZHONG on 2016/10/9.
 */
@WebServlet(name = "DBDelete")
public class DBDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "DELETE FROM Score WHERE s_id = ?";

        PreparedStatement ps = null;
        Connection conn = DBHelper.connetDB();
        int result = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,"1430003045");
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeDB();
        }

        String message = null;

        if (result == 0)
        {
            message = "Delete failed.";
        }
        else
        {
            message = "Delete succeed";
        }

        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
