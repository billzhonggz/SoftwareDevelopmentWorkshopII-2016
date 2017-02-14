<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/21
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Assessment</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="instructorHome.jsp">UIC CILO System</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">

            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="instructorHome.jsp"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="indexN.html"><i class="fa fa-gear fa-fw"></i> Change Profile</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="sidebar-search">
                        <div class="input-group custom-search-form">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                        <!-- /input-group -->
                    </li>
                    <li>
                        <a href="instructorHome.jsp"><i class="fa fa-dashboard fa-fw"></i> My course</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Add new <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="addNewCourse.jsp">New Course</a>
                            </li>
                            <li>
                                <a href="addQuestion.jsp">Qusetion Paper</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="courseReport.jsp"><i class="fa fa-table fa-fw"></i> CILO Analysis</a>
                    </li>
                    <li>
                        <a href="studentPerformance.jsp"><i class="fa fa-edit fa-fw"></i> Students' Info</a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-files-o fa-fw"></i> Contact Us<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="aboutDevelopers.jsp">Bill</a>
                            </li>
                            <li>
                                <a href="aboutDevelopers.jsp">David</a>
                            </li>
                            <li>
                                <a href="aboutDevelopers.jsp">Frank</a>
                            </li>
                            <li>
                                <a href="aboutDevelopers.jsp">ZhouHL</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Add New Assessment</h1>
            </div>
            <%
                String c_id = (String)session.getAttribute("c_id");
            %>
            <div class="row">
                <div class="col-lg-8">
                    <div class="alert alert-info">
                        You are adding assessment for course ID <%out.print(c_id);%>.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <form method="get" action="/addAssessment">
                        <div class="form-group">
                            <label>Assessment Name</label>
                            <input type="text" class="form-control" name="A_Name">
                        </div>
                        <div class="form-group">
                            <label>Assessment Type</label>
                            <select class="form-control" name="A_Type">
                                <option>Assignment</option>
                                <option>Quiz</option>
                                <option>Midterm Test</option>
                                <option>Final Exam</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Percentage</label>
                            <input type="number" class="form-control" name="Percentage">
                        </div>
                        <button type="submit" name="saveAssessment" class="btn btn-primary">Submit and Save Assessment</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
