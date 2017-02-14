<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/8/21
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Test - Input Name</title>
</head>
<body>
        <form action="people.jsp" method="get" name="form">
            <p>请输入姓名：</p>
            <input type="text" name="name">
            <br/>
            <input type="submit" value="提交" name="submit">
        </form>
</body>
</html>
