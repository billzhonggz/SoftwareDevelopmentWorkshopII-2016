package upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ZHONG on 2016/10/19.
 */
@WebServlet(name = "ImportData")
public class ImportData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    public ImportData() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //allow file types
        String[] allowTypes = new String[] { "xls", "xlsx" };

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        // file store path
        String path = "C://Users//ZHONG//Desktop";

        JSONArray array = null;

        try {
            List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {

                } else {
                    // check the upload file
                    if (item.getName() != null && !item.getName().equals("")) {
                        String name = item.getName();
                        name = name.substring(name.lastIndexOf("\\") + 1);
                        System.out.println(name);
                        String type = name.substring(name.lastIndexOf('.') + 1);
                        boolean flag = false;
                        for (String at : allowTypes) {
                            if (at.equals(type)) {
                                flag = true;
                            }
                        }

                        // file type not match
                        if (flag == false) {
                            System.out.println("文件格式不支持");
                            request.setAttribute("message", "文件格式不支持");

                            RequestDispatcher rd = request.getRequestDispatcher("importdata.jsp");
                            rd.forward(request, response);
                        } else {
                            int start = name.lastIndexOf("\\");
                            String filename = name.substring(start + 1);


                            // save the upload file into target directory
                            File file = new File(path + "\\" + filename);
                            item.write(file);
                            request.setAttribute("course", name);


                            // 调用ReadWriteExcel的静态方法 readExcel()去处理excel文件
                            array = ReadWriteExcel.readExcel(path, name);

                            //获取 JSONArray 传递给resultdata.jsp页面
                            RequestDispatcher rd = request.getRequestDispatcher("resultdata.jsp");
                            request.setAttribute("resultData", array);
                            rd.forward(request, response);

                        }
                    } else {
                        System.out.println("请选择待上传文件");
                        request.setAttribute("message", "请选择待上传文件");
                        RequestDispatcher rd = request.getRequestDispatcher("importdata.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "文件上传失败");
        }
    }
}
