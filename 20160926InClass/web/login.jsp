<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/26
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="post" action="checkLogin.jsp">
        <table>
            <tr>
                <td>Name: </td>
                <td>
                    <input type="text" name="name" value=<%= request.getParameter("user")%>>
                </td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="pwd"></td>
            </tr>
            <tr colspan="2">
                <td>
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
