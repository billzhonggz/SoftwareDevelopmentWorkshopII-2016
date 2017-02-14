<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/26
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Names</title>
</head>
<body>
    <form method="get" action="Controller" name="showall">
        <table>
            <tr>
                <td>
                    <input type="checkbox" name="id1"/>
                </td>
                <td>Jim</td>
                <td>Smith</td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="id2"/>
                </td>
                <td>Jim</td>
                <td>Bean</td>
            </tr>
        </table>
        <p>
            <input type="submit" name="delete" value="delete"/>&nbsp;
            <input type="submit" name="edit" value="edit"/>&nbsp;
            <input type="reset" value="reset">
        </p>
    </form>
</body>
</html>
