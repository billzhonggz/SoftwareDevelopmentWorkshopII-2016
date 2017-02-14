<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/3
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.json.JSONArray" %>
<%@page import="org.json.JSONException" %>
<%@ page import="org.omg.CORBA.Object" %>
<%@ page import="org.json.JSONObject" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="asset/semantic.min.css">
    <script src="asset/semantic.min.js"></script>
    <script src="asset/jquery-3.1.1.min.js"></script>
    <title>Import Data</title>
</head>
<body>
    <h2 class="ui centered aligned icon header">
        <i class="file excel outline icon olive">
            ${course}
        </i>
    </h2>
<div class="ui two column centered grid">
    <div class="column">
        <%
            Object result = request.getAttribute("resultData");
            JSONArray array = (JSONArray)result;
            JSONObject jsonObj = null;
        %>
        <table class="ui selected celled table">
            <thead>
            <tr>
                <th>Student ID</th>
                <th>Quiz</th>
                <th>Assignment</th>
                <th>Lab</th>
                <th>Exam</th>
                <th>Final</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < array.length(); i++)
                {
                    jsonObj = (JSONObject)array.get(i);
            %>
            <tr>
                <td>
                    <h4 class="ui image header"
                        <img src="asset/images/lena.png" class="ui mini rounded image">
                    <div class="content">
                        <%
                            out.println(jsonObj.get("Student ID"));
                        %>
                    </div>
                    </h4>
                </td>
                <td>
                    <%
                        out.println(jsonObj.get("Quiz"));
                    %>
                </td>
                <td>
                    <%
                        out.println(jsonObj.get("Assignment"));
                    %>
                </td>
                <td>
                    <%
                        out.println(jsonObj.get("Lan"));
                    %>
                </td>
                <td>
                    <%
                        out.println(jsonObj.get("Exam"));
                    %>
                </td>
                <td>
                    <%
                        out.println(jsonObj.get("Final"));
                    %>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div class="four column centered row">
        <div class="column"></div>
        <div class="column"></div>
    </div>
</div>
</body>
</html>
