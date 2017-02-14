package com.billzhonggz.workshop2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by ZHONG on 2016/9/19.
 */
@WebServlet(name = "HelloHomework")
public class HelloHomework extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "The New Question Has Added";
        out.println("<html>" +
                    "<body>\n" +
                    "<h1 align = center>" + title + "<h1>\n" +
                    "<table border = 1 align = center>\n" +
                    "<tr>\n");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements())
        {
            String paramName = (String)paramNames.nextElement();
            out.println("<TR><TD>" + paramName + "\n<TD>");
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1)
            {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0)
                    out.print("<I>No Value</I>");
                else
                    out.print(paramValue);
            }
            else
            {
                out.println("<UL>");
                for (int i = 0; i < paramValues.length; i++)
                {
                    out.println("<LI>" + paramValues[i]);
                }
                out.println("</UL>");
            }
        }
        out.println("</TABLE>\n" +
                    "<a align = center href = 'homework.jsp'><button type = 'button'>Back</button></a>" +
                    "</BODY></HTML>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
