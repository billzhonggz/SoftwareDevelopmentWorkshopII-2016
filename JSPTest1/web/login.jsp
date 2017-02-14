<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/11/21
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <%--<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->--%>
    <%--<link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="dist/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">
    <form class="form-signin" method="post" action="/loginControl">
        <h2 class="form-signin-heading">Welcome</h2>
        <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" name="name" placeholder="Your name here"
                   onkeyup="this.value=this.value.replace(/[^A-Za-z]/g,'');">
        </div>
        <div class="form-group">
            <label>You like:</label>
            <div class="radio">
                <label><input type="radio" name="school" value="hkbu" checked>HKBU</label>
                <label><input type="radio" name="school" value="ust">UST</label>
            </div>
        </div>
        <button class="btn btn-primary" type="submit" value="Submit"
                onclick="isAlphabet(this,'Please enter only letters for your name')">Submit
        </button>
    </form>
</div>
</body>
</html>
