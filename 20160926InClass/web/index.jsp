<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/26
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Using Java Server Pages</title>
  </head>
  <body bgcolor="#FDF5E6" text="#000000">
    <center>
      <table border="5" bgcolor="#EF8429">
        <tr>
          <th class="title">Using Java Server Pages</th>
        </tr>
      </table>
    </center>
    <p>Some dynamic content created using various JSP mechanisms</p>
    <ul>
      <li><b>Expression.</b><br>
        Your hostname: <%= request.getRemoteHost() %>.
      </li>
      <li><b>Scriptlet.</b><br>
        <% out.println("Attached GET data: " + request.getQueryString()); %>
      </li>
      <li><b>Declaration (plus expression).</b><br>
        <%! private int accessCount = 0; %>
        Accesses to page since server reboot: <%= ++accessCount%>
      </li>
      <li><b>Directive (plus expression).</b><br>
        <%@ page import="java.util.*" %>
        Current date: <%= new Date()%>
      </li>
    </ul>
  </body>
</html>
