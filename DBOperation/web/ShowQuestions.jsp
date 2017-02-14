<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.billzhonggz.DBHelper" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/10
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Questions</title>
</head>
<body>
<%
    ResultSet resultSet = (ResultSet)request.getAttribute("resultSet");
%>
<table>
    <tr>
        <th>Question</th>
        <th>Weighting</th>
        <th>Cognitive Level</th>
    </tr>
    <%
        try{
        while (resultSet.next())
        {
    %>
    <tr>
        <td><%resultSet.getString("Q_Description");%></td>
        <td><%resultSet.getString("Percentage");%></td>
        <td></td>
    </tr>
    <%
        }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        DBHelper.closeDB();
    %>
</table>
</body>
</html>
