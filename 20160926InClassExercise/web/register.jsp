<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/26
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Registration</h1>
    <form action="LoginControl">
        <table>
            <tr>
                <td>User Name</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input type="password" name="pwd">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="regSubmit" value="Submit">
                </td>
                <td>
                    <input type="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
