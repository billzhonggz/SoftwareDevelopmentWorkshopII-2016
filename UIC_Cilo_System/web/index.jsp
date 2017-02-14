<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/15
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Redirecting</title>
    <%--Auto load servlet--%>
    <script>
      function GetData() {
        window.location.href = "/showInstructorHome?t_id=1"
      }
    </script>
    <meta http-equiv="refresh" content="0; url=pages/instructorHome.jsp">
  </head>
  <body onload="GetData()">
  Redirect to homepage...
  </body>
</html>
