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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ZHONG on 2016/10/10.
 */
@WebServlet(name = "ManageQuestion")
public class ManageQuestion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int buttonClicked = 0;
        if (request.getParameter("Save") != null) {
            String question = request.getParameter("question");
            int weighting = Integer.parseInt(request.getParameter("weighting"));
            String cl = request.getParameter("cl");
            //Set up query statement.
            String sql = "INSERT INTO Question (Q_Description,Percentage,Q_type) VALUES (?,?,0)";
            PreparedStatement ps = null;
            //Get db connect.
            Connection conn = DBHelper.connetDB();
            int result = 0;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, question);
                ps.setInt(2, weighting);
                result = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBHelper.closeDB();
            }
            String message = null;
            if (result == 0) {
                message = "Insertion failed.";
            } else {
                message = "Insertion succeed.";
            }
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("AddNewQuestion.jsp");
            rd.forward(request, response);
        } else {
            //Set up query statement.
            String sql = "SELECT * FROM Question";
            PreparedStatement ps = null;
            ResultSet rs = null;
            int q_id = 0;
            String question = null;
            int q_type = 0;
            int weighting = 0;
            //Get DB connection.
            Connection conn = DBHelper.connetDB();
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    q_id = Integer.parseInt(rs.getString("Q_ID"));
                    question = rs.getString()

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            finally {
//                DBHelper.closeDB();
//            }
            request.setAttribute("resultSet", rs);
            RequestDispatcher rd = request.getRequestDispatcher("ShowQuestions.jsp");
            rd.forward(request, response);
        }
    }
}
