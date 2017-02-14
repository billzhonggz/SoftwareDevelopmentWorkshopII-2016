<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/19
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Import Data</title>
</head>
<body>
    <h1>Import Data Through Excel</h1>
    <div class="ui two column centered grid">
        <div class="column">
            <div class="">
                <form class="ui form" enctype="multipart/form-data" action="importData" method="post">
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
