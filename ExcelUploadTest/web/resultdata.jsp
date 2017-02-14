<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/19
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Data</title>
</head>
<body>
<div class="ui two column centered grid">
    <div class="column">
        <%
            Object result = request.getAttribute("resultData");
            //out.print(result);
            JSONArray array = (JSONArray) result;
            JSONObject jsonObj = null;
        %>
        <table class="ui selectable celled table">
            <thead>
            <tr>
                <th>studentid</th>
                <th>quiz</th>
                <th>assignment</th>
                <th>lab</th>
                <th>exam</th>
                <th>final</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i = 0; i < array.length(); i++) {
                    jsonObj = (JSONObject) array.get(i);
            %>

            <tr>
                <td>

                    <div class="content">
                        <%
                            out.print(jsonObj.get("studentid"));
                        %>
                    </div>

                </td>
                <td>
                    <%
                        out.print(jsonObj.get("quiz"));
                    %>
                </td>
                <td>
                    <%
                        out.print(jsonObj.get("assignment"));
                    %>
                </td>
                <td>
                    <%
                        out.print(jsonObj.get("lab"));
                    %>
                </td>
                <td>
                    <%
                        out.print(jsonObj.get("exam"));
                    %>
                </td>
                <td>
                    <%
                        out.print(jsonObj.get("final"));
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
