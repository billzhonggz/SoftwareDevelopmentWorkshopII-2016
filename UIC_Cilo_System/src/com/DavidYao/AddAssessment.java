package com.DavidYao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ZHONG on 2016/10/21.
 */
@WebServlet(name = "AddAssessment")
public class AddAssessment extends HttpServlet {
    private MySQLAccess DBA;

    public void init() throws ServletException {
        DBA = new MySQLAccess();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        if (parameters.containsKey("saveAssessment")) {
            String sC_ID = (String)request.getSession().getAttribute("c_id");
            int C_ID = Integer.parseInt(sC_ID);
            String A_Name = request.getParameter("A_Name");
            String A_type = request.getParameter("A_Type");
            String A_TypeConvert = null;
            switch (A_type)
            {
                case "Assignment": A_TypeConvert = "A";
                    break;
                case "Quiz": A_TypeConvert = "Q";
                    break;
                case "Midterm Test": A_TypeConvert = "M";
                    break;
                case "Final Exam": A_TypeConvert = "F";
                    break;
            }
            int Percentage = Integer.parseInt(request.getParameter("Percentage"));
            try {
                DBA.writeAssessment(C_ID, A_Name, A_TypeConvert, Percentage);
            } catch (Exception e) {
                getServletContext().log("An exception occurred in writeAssessment", e);
                throw new ServletException("An exception occurred in writeAssessment" + e.getMessage());
            }
            request.setAttribute("message","Assessment added successfully.");
            request.setAttribute("c_id",sC_ID);
            RequestDispatcher view = request.getRequestDispatcher("/showCourseDetail");
            view.forward(request, response);
        } else {
        }
    }
}
