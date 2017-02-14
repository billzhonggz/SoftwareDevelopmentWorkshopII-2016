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
 * Created by ZHONG on 2016/10/24.
 */
@WebServlet(name = "EditQuestion")
public class EditQuestion extends HttpServlet {
    private MySQLAccess DBA;

    public void init() throws ServletException {
        DBA = new MySQLAccess();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        if (parameters.containsKey("saveQuestion")) {
            int Q_ID = Integer.parseInt(request.getParameter("Q_ID"));
            String sA_ID = (String) request.getSession().getAttribute("A_ID");
            int A_ID = Integer.parseInt(request.getParameter("A_ID"));
            String Q_Description = request.getParameter("Q_Description");
            String picUrl = request.getParameter("picUrl");
            int Q_Number = Integer.parseInt(request.getParameter("Q_Number"));
            int Percentage = Integer.parseInt(request.getParameter("Percentage"));
            String cogLevel = request.getParameter("cogLevel");
            int CI_ID = Integer.parseInt(request.getParameter("CI_ID"));
            try {
                DBA.editQuestion(Q_ID, Q_Description, picUrl, A_ID, Q_Number, Percentage, cogLevel, CI_ID);
            } catch (Exception e) {
                getServletContext().log("An exception occurred in editQuestion", e);
                throw new ServletException("An exception occurred in editQuestion" + e.getMessage());
            }

            RequestDispatcher view = request.getRequestDispatcher("/EditAssessment.jsp");
            view.forward(request, response);
        } else {

        }
    }
}
