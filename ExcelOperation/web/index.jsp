<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/3
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="asset/semantic.min.css">
    <script src="asset/semantic.min.js"></script>
    <script src="asset/jquery-3.1.1.min.js"></script>
    <title>Import Data</title>
  </head>
  <body>
  <h2 class="ui center aligned icon header">
    <i class="file excel outline icon olive"></i>
    Import Data Through Excel
  </h2>
  <div class="ui two column centered grid">
    <div class="column">
      <div class="">
        <form class="ui form" enctype="multipart/form-data" action="/ChartDemo/ImportData" method="post">
          <div class="field">
            <label>Import Excel File</label>
            <input type="file" name="file" placeholder="">
            <input type="hidden" name="action" value="importAction">
          </div>
          <button class="ui button" type="submit">Submit</button>
        </form>
      </div>
    </div>
    <div class="four column centered row">
      <div class="column">${message}</div>
    </div>
  </div>

  </body>
</html>
