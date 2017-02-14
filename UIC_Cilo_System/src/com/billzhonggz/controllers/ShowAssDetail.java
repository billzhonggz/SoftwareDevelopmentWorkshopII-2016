package com.billzhonggz.controllers;

import com.DavidYao.MySQLAccess;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ZHONG on 2016/10/27.
 */
@WebServlet(name = "ShowAssDetail")
public class ShowAssDetail extends HttpServlet {
    MySQLAccess DBA = new MySQLAccess();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sA_ID = request.getParameter("a_id");
        int A_ID = Integer.parseInt(sA_ID);
        ArrayList<HashMap<String, String>> assInfo = new ArrayList<>();
        //Query information.
        try {
             assInfo = DBA.readAssessmentByA_ID(A_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, String> row = assInfo.get(0);
        String message;
        //Put information to requests.
        if (row.get("A_Name") == null)
            message = "Operation Failed.";
        else
        {
            String A_Type;
            switch (row.get("A_Type")) {
                case "F":
                    A_Type = "Final Exam";
                    break;
                case "M":
                    A_Type = "Midterm Test";
                    break;
                case "Q":
                    A_Type = "Quiz";
                    break;
                case "A":
                    A_Type = "Assignment";
                    break;
                default:
                    A_Type = "N/A";
            }
            request.setAttribute("A_ID",sA_ID);
            request.setAttribute("A_Name",row.get("A_Name"));
            request.setAttribute("A_Type",A_Type);
            request.setAttribute("Percentage",row.get("Percentage"));
            request.setAttribute("message","Operation succeed.");
        }
        RequestDispatcher rd = request.getRequestDispatcher("pages/viewAssessment.jsp");
        rd.forward(request,response);
    }
}
