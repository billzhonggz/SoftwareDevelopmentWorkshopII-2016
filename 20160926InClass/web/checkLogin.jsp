<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/26
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Check Page</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        String password = request.getParameter("pwd");

        System.out.println("111" + name + " " + password);
        if (name.equals("Gigi") && password.equals("123456"))
        {
            System.out.println(222);
    %>
            <jsp:forward page="success.jsp">
                <jsp:param name="user" value="<%=name%>" />
            </jsp:forward>
    <%
        }
        else
        {
    %>
            <jsp:forward page="login.jsp">
                <jsp:param name="user" value="<%=name%>"/>
            </jsp:forward>
    <%  }
    %>
</body>
</html>
