<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/26
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Page</title>
</head>
<body>
    <form method="get" action="Controller" name="edit">
        <table>
            <tr>
                <td>First name: </td>
                <td>
                    <input type="text" name="firstName">
                </td>
            </tr>
            <tr>
                <td>Last name: </td>
                <td>
                    <input type="text" name="lastName">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="sava">
                    <input type="reset" value="reset">
                    <input type="submit" value="back">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
