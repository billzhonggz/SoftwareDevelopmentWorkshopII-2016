package WordOutput;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZHONG on 2016/10/23.
 */
@WebServlet(name = "CreateWordDoc")
public class CreateWordDoc extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_id = request.getParameter("c_id");
        CreateReport cr = new CreateReport();
        String message = null;
        try {
            cr.CreateReportDoc();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        message = "Report created succeed.";
//        request.setAttribute("message",message);
//        RequestDispatcher rd = request.getRequestDispatcher("/showCourseDetail?c_id=" + c_id);
//        rd.forward(request,response);
    }
}
