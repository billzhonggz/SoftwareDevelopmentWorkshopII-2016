<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/8
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>MySQL Operation</title>
    <style type="text/css">
      .action {
        width: 500px;
        height: 200px;
        margin: 0 auto;
        background: rgba(234, 233, 233, 0.22);
        margin-top: 50px;
      }

      .result {
        width: 500px;
        height: 100px;
        margin: 0 auto;
        background: rgba(189, 187, 104, 0.22);
        margin-top: 50px;
      }

      .action li {
        list-style: none;
        padding-top: 20px;
      }
    </style>
  </head>
  <body>
  <div class="action">
    <div>JSP MySQL Simple Operations</div>
    <ul>
      <li>
        <a href="/insert">Insert</a>
      </li>
      <li>
        <a href="/select">Select</a>
      </li>
      <li>
        <a href="/update">Update</a>
      </li>
      <li>
        <a href="/delete">Delete</a>
      </li>
      <li>
        <a href="AddNewQuestion.jsp">Add New Question (Oct 10th In Class)</a>
      </li>
    </ul>
  </div>
  <div class="result">
    <div>Result:</div>
    <div>${message}</div>
    <div>${studentid}</div>
    <div>${quiz}</div>
    <div>${exam}</div>
  </div>
  </body>
</html>
