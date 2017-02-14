package com.billzhonggz;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
 * Created by ZHONG on 2016/10/3.
 */
@WebServlet(name = "ImportData")
public class ImportData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //Set allow file types.
        String[] allowTypes = new String[] {"xls","xlsx"};

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //File Storing.
        String path = "C://jspfile";

        JSONArray array = null;

        try {
            List<FileItem> items = (List<FileItem>)upload.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext())
            {
                FileItem item = (FileItem) itr.next();
                if(item.isFormField())
                {

                }
                else
                {
                    //Check uploaded file.
                    if(item.getName() != null && !item.getName().equals(""))
                    {
                        String name = item.getName();
                        name = name.substring(name.lastIndexOf("\\") + 1);
                        System.out.println(name);
                        String type = name.substring(name.lastIndexOf('.' + 1));
                        boolean flag = false;
                        for (String at : allowTypes)
                        {
                            if(at.equals(type))
                            {
                                flag = true;
                            }
                        }
                        //File type doesn't match.
                        if (flag == false)
                        {
                            System.out.println("File type not supported.");
                            request.setAttribute("message","File type not supportd.");

                            RequestDispatcher rd = request.getRequestDispatcher("importdata.jsp");
                            rd.forward(request,response);
                        }
                        else
                        {
                            int start = name.lastIndexOf("\\");
                            String filename = name.substring(start + 1);

                            //Save the file into target dir.
                            File file = new File(path + "\\" + filename);
                        }
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
