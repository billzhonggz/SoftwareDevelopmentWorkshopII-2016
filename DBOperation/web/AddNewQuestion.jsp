<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/10
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a New Question</title>
</head>
<body>
    <h1>Add a New Question</h1>
    <form method="get" action="/manage-question">
        <p>Question</p>
        <textarea name="question" placeholder="Insert your question here..."></textarea>

        <p>Weighting</p>
        <input type="number" name="weighting">

        <p>Cognitive Level</p>
        <input type="radio" name="cl" value="Knowledge">Knowledge
        <br>
        <input type="radio" name="cl" value="Analysis">Analysis
        <br>
        <input type="radio" name="cl" value="Evaluation">Evaluation
        <br>
        <input type="submit" value="Save">
        <input type="submit" value="Show">
    </form>
    <p>${message}</p>
</body>
</html>
