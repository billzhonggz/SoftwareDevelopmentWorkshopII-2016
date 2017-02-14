<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/11/21
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

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
    <%--Logo here!--%>
    <div class="row">
        <div class="col-lg-4 col-lg-offset-6">
            <% String logoUrl = "<image class=\"img-responsive\" src=" + request.getAttribute("picUrl") + ">";
                out.print(logoUrl);
            %>
        </div>
    </div>
    <%--Other information--%>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="alert-danger">${message}</div>
            <p class="lead">Hello ${name}!</p>
            <p class="lead">Welcome to ${school}!</p>
            <button class="btn btn-primary" onclick="window.history.back()">Back</button>
        </div>
    </div>
</div>
</body>
</html>
