package com.billzhonggz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ZHONG on 2016/9/24.
 */
@WebServlet(name = "ShowChart")
public class ShowChart extends HttpServlet {
    private MySQLDB mysqlConn = new MySQLDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = mysqlConn.getConnection();
        String sql = "SELECT * FROM chart_demo";
        PreparedStatement ps;
        ResultSet rs = null;

        try {
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String data = null;

        try {
            if (rs.next()) {
                data = resultSetToJson(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(data);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("chartData",data);
        rd.forward(request,response);
    }

    public String resultSetToJson(ResultSet rs) throws SQLException, JSONException {
        // json数组
        JSONArray array = new JSONArray();

        // 获取列数
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // 遍历ResultSet中的每条数据
        while (rs.next()) {
            JSONObject jsonObj = new JSONObject();

            // 遍历每一列
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnLabel(i);

                if (columnName.equals("y")) {
                    int value = rs.getInt(columnName);
                    jsonObj.put(columnName, value);//Put col data into json array.

                } else {
                    String value = rs.getString(columnName);
                    jsonObj.put(columnName, value);
                }

                //jsonObj.put(columnName, value);
            }
            array.put(jsonObj);
        }

        return array.toString();
    }
}

