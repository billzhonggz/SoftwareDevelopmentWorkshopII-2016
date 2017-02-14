package com.billzhonggz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ZHONG on 2016/9/26.
 */
@WebServlet(name = "LoginControl")
public class LoginControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String SUCCESS = "/loginSuccess.jsp";
    private static String NEED_REG = "/register.jsp";
    private static String LOGIN = "/login.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String forward = "";
        Map<String, String[]> parameters = request.getParameterMap();
        if (name.equals("Smith") && pwd.equals("123456"))
        {
            forward = SUCCESS;
        }
        else if (parameters.containsKey("regBack") || parameters.containsKey("regSubmit"))
        {
            forward = LOGIN;
        }
        else
        {
            forward = NEED_REG;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request,response);
    }
}
