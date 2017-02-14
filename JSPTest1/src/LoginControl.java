import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by ZHONG on 2016/11/21.
 */
@WebServlet(name = "LoginControl")
public class LoginControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String HKBU = "hkbu.png";
    private static String UST = "ust.png";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String school = request.getParameter("school");
        String picUrl = "";
        String schoolName = "";
        // Write to database
//        String sql = "INSERT INTO test (name,school) VALUES (?,?)";
//        PreparedStatement ps =null;
//        Connection conn = DBHelper.connetDB();
//        int result = 0;
//        try {
//            ps = conn.prepareStatement(sql);
//            ps.setString(1,name);
//            ps.setString(2,school);
//            result = ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (result == 0)
//        {
//            message = "Fail to write to database.";
//        }
//        else
//        {
//            message = "Write to database succeed.";
//        }
        //Map<String,String[]> parameters = request.getParameterMap();
        if (school.equals("hkbu"))
        {
            picUrl = HKBU;
            schoolName = "HKBU";
        }
        else
        {
            picUrl = UST;
            schoolName = "UST";
        }
        //request.setAttribute("message",message);
        request.setAttribute("name",name);
        request.setAttribute("picUrl",picUrl);
        request.setAttribute("school",schoolName);
        RequestDispatcher view = request.getRequestDispatcher("/welcome.jsp");
        view.forward(request,response);
    }
}
