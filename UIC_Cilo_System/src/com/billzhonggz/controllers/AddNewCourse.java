package com.billzhonggz.controllers;

import com.billzhonggz.DBDemo.DBHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ZHONG on 2016/10/15.
 */
@WebServlet(name = "AddNewCourse")
public class AddNewCourse extends HttpServlet {
    //Insert assessment and return a_id.
    private int InsertAssessment(Connection conn, String type, int percentage) {
        //Insert assessment.
        String sqlIns = "INSERT INTO Assessment(A_Type,Percentage) VALUES(?,?)";
        int result = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlIns);
            ps.setString(1, type);
            ps.setInt(2, percentage);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 0)
            return 0;

        //Get last A_ID.
        String sqlGetLastAID = "SELECT LAST_INSERT_ID() AS last_id FROM Assessment";
        int a_id = 0;
        ResultSet rs = null;
        ps = null;
        try {
            ps = conn.prepareStatement(sqlGetLastAID);
            rs = ps.executeQuery();
            while (rs.next()) {
                a_id = Integer.parseInt(rs.getString("last_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a_id;
    }

    //Connect C_ID and A_ID.
    private int ConnectCIDAID(Connection conn, int c_id, int a_id) {
        String sqlConnAidCid = "INSERT INTO C_A(A_ID,C_ID) VALUES(?,?)";
        PreparedStatement ps = null;
        int result = 0;
        try {
            ps = conn.prepareStatement(sqlConnAidCid);
            ps.setInt(1, a_id);
            ps.setInt(2, c_id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        if (result == 0)
            return 0;
        return 1;
    }

    private int InsertCilo(Connection conn, String description) {
        //Insert cilo.
        String sqlIns = "INSERT INTO CILO(CI_Description) VALUES(?)";
        int result = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlIns);
            ps.setString(1, description);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 0)
            return 0;

        //Get last ci_ID.
        String sqlGetLastAID = "SELECT LAST_INSERT_ID() AS last_id FROM CILO";
        int ci_id = 0;
        ResultSet rs = null;
        ps = null;
        try {
            ps = conn.prepareStatement(sqlGetLastAID);
            rs = ps.executeQuery();
            while (rs.next()) {
                ci_id = Integer.parseInt(rs.getString("last_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ci_id;
    }

    //Connect CI_ID and C_ID
    private int ConnectCIDCIID(Connection conn, int c_id, int ci_number,int ci_id) {
        String sqlConnAidCid = "INSERT INTO C_CI(CI_ID,C_ID,CI_Number) VALUES(?,?,?)";
        PreparedStatement ps = null;
        int result = 0;
        try {
            ps = conn.prepareStatement(sqlConnAidCid);
            ps.setInt(1, ci_id);
            ps.setInt(2, c_id);
            ps.setInt(3, ci_number);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        if (result == 0)
            return 0;
        return 1;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Obtain all input information.
        String c_name = request.getParameter("newCourseName");
        String c_code = request.getParameter("newCourseCode");
        String perFinal = request.getParameter("per-final");
        String perMidterm = request.getParameter("per-midterm");
        String perQuiz = request.getParameter("per-quiz");
        String perAssignment = request.getParameter("per-assignment");
        String cilo1 = request.getParameter("cilo-1");
        String cilo2 = request.getParameter("cilo-2");
        String cilo3 = request.getParameter("cilo-3");
        String cilo4 = request.getParameter("cilo-4");
        String cilo5 = request.getParameter("cilo-5");

        //Get DB connection.
        int errorCount = 0;
        String message = null;
        Connection conn = DBHelper.connetDB();

        //Insert
        PreparedStatement ps = null;
        String sqlInsert = "INSERT INTO Course(C_Code,C_Name,T_ID,Score) VALUES(?,?,1,1)";
        int result = 0;
        try {
            ps = conn.prepareStatement(sqlInsert);
            ps.setString(1, c_code);
            ps.setString(2, c_name);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 0)
            errorCount++;

        //Query C_ID.
        String sqlGetCID = "SELECT LAST_INSERT_ID() AS last_id FROM Course";
        int c_id = 0;
        ResultSet rs = null;
        ps = null;
        try {
            ps = conn.prepareStatement(sqlGetCID);
            rs = ps.executeQuery();
            while (rs.next()) {
                c_id = Integer.parseInt(rs.getString("last_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (c_id == 0)
            errorCount++;

        //Insert assessments (FINAL).
        int f_id = InsertAssessment(conn, "F", Integer.parseInt(perFinal));
        if (f_id == 0)
            errorCount++;
        //Connect F_ID and C_ID.
        if (ConnectCIDAID(conn, c_id, f_id) == 0)
            errorCount++;

        //Insert Midterm.
        int m_id = InsertAssessment(conn, "M", Integer.parseInt(perMidterm));
        if (m_id == 0)
            errorCount++;
        //Connect M_ID and C_ID
        if (ConnectCIDAID(conn, c_id, m_id) == 0)
            errorCount++;

        //Insert Quizzes.
        int q_id = InsertAssessment(conn, "Q", Integer.parseInt(perQuiz));
        if (q_id == 0)
            errorCount++;
        //Connect Q_ID and C_ID.
        if (ConnectCIDAID(conn, c_id, q_id) == 0)
            errorCount++;

        //Insert Assignments.
        int ass_id = InsertAssessment(conn, "A", Integer.parseInt(perAssignment));
        if (ass_id == 0)
            errorCount++;
        //Connect ASS_ID and C_ID.
        if (ConnectCIDAID(conn, c_id, ass_id) == 0)
            errorCount++;

        //Add CILOs.
        //Insert cilo1.
        int cilo_1_id = InsertCilo(conn, cilo1);
        if (cilo_1_id == 0)
            errorCount++;
        //Connect cilo1 to C_ID.
        if (ConnectCIDCIID(conn, c_id, 1, cilo_1_id) == 0)
            errorCount++;

        //Insert cilo2.
        int cilo_2_id = InsertCilo(conn, cilo2);
        if (cilo_2_id == 0)
            errorCount++;
        //Connect cilo2 to C_ID.
        if (ConnectCIDCIID(conn, c_id, 2, cilo_2_id) == 0)
            errorCount++;

        //Insert cilo3.
        int cilo_3_id = InsertCilo(conn, cilo3);
        if (cilo_3_id == 0)
            errorCount++;
        //Connect cilo3 to C_ID.
        if (ConnectCIDCIID(conn, c_id, 3, cilo_3_id) == 0)
            errorCount++;

        //Insert cilo4.
        int cilo_4_id = InsertCilo(conn, cilo4);
        if (cilo_4_id == 0)
            errorCount++;
        //Connect cilo4 to C_ID.
        if (ConnectCIDCIID(conn, c_id, 4, cilo_4_id) == 0)
            errorCount++;

        //Insert cilo5.
        int cilo_5_id = InsertCilo(conn, cilo5);
        if (cilo_5_id == 0)
            errorCount++;
        //Connect cilo5 to C_ID.
        if (ConnectCIDCIID(conn, c_id, 5, cilo_5_id) == 0)
            errorCount++;

        //Close DB connection.
        DBHelper.closeDB();
        //Return results.
        if (errorCount == 0)
            message = "Course added successfully.";
        else
            message = "Course added failed. ";
        request.setAttribute("message", message);
        RequestDispatcher rd = request.getRequestDispatcher("pages/addNewCourse.jsp");
        rd.forward(request, response);
    }
}