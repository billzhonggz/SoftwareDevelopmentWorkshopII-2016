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
@WebServlet(name = "EditAssessment")
public class EditAssessment extends HttpServlet {
    private MySQLAccess DBA;

    public void init() throws ServletException {
        DBA = new MySQLAccess();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        if (parameters.containsKey("addNewQuestion")) {
            RequestDispatcher view = request.getRequestDispatcher("/AddQuestion.jsp");
            view.forward(request, response);
        } else if (parameters.containsKey("editQuestion")) {
            RequestDispatcher view = request.getRequestDispatcher("/EditQuestion.jsp");
            view.forward(request, response);
        } else if (parameters.containsKey("up")) {

        } else if (parameters.containsKey("down")) {

        } else if (parameters.containsKey("delete")) {
            String sA_ID = (String) request.getSession().getAttribute("A_ID");
            int A_ID = Integer.parseInt(sA_ID);
            int Q_ID = Integer.parseInt(request.getParameter("Q_ID"));
            try {
                DBA.deleteQuestion(Q_ID, A_ID);
            } catch (Exception e) {
                getServletContext().log("An exception occurred in deleteQuestion", e);
                throw new ServletException("An exception occurred in deleteQuestion" + e.getMessage());
            }

            RequestDispatcher view = request.getRequestDispatcher("/EditAssessment.jsp");
            view.forward(request, response);
        } else {

        }
    }
}
