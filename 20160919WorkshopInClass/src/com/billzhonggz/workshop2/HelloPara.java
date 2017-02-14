package com.billzhonggz.workshop2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ZHONG on 2016/9/19.
 */
@WebServlet(name = "HelloPara")
public class HelloPara extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "Reading Three Request Parameters";
        out.println("<html>" +
                    "<body>\n" +
                    "<h1 align = center>" + title + "<h1>\n" +
                    "<ul>\n" +
                    "   <li>param1: "
                    + request.getParameter("param1") + "\n" +
                    "   <li>param2: "
                    + request.getParameter("param2") + "\n" +
                    "   <li>param3: "
                    + request.getParameter("param3") + "\n" +
                    "</ul>\n" +
                    "</body></html>");
    }
}
