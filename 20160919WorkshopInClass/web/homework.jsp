<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/19
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a New Question</title>
</head>
<body>
    <form action = "/hellohomework" method="post">
        <p>Question</p>
        <textarea name = "question" rows = "10" cols="30">

        </textarea>
        <p>Weighting</p>
        <input type = "number" name = "weighting">
        <br/>
        <p>Cognitive Level</p>
        <input type = "radio" name = "Knowledge">Knowledge
        <input type = "radio" name = "Analysis">Analysis
        <input type = "radio" name = "Evluation">Evluation
        <input type="submit" value="Submit">
    </form>
</body>
</html>
