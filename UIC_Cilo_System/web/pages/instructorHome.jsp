<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UIC CILO System</title>

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
                <h1 class="page-header">Instructor Homepage</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-info">${message}</div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8">
                <div class="panel panel-default">
                    <div class="panel panel-heading">
                        Basic Information
                    </div>
                    <div class="panel-body">
                        <%--TODO: Insert instructor's information here.--%>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Instructor ID in Database</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${t_id}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <Strong>Name</Strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${t_name}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Division</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>DST</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Programme</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${t_department}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Position</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${t_position}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Entry Date</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${t_e_date}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <img src="/images/gigi.jpg" class="img-responsive img-thumbnail">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Courses
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Course ID</th>
                                <th>Course Code</th>
                                <th>Course Name</th>
                                <th>Detail</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                Object courses[][] = (Object[][])request.getAttribute("courseReturn");
                                for (int i = 0; i < courses.length; i++)
                                {
                            %>
                            <tr>
                                <td><%out.print(courses[i][0]);%></td>
                                <td><%out.print(courses[i][1]);%></td>
                                <td><%out.print(courses[i][2]);%></td>
                                <%--TODO: Find out a way to put c_id and html statement together.--%>
                                <td>
                                    <%
                                        String detail = "<a href='/showCourseDetail?c_id=";
                                        detail = detail + courses[i][0];
                                        detail = detail + "'>Detail</a>";
                                        out.print(detail);
                                    %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                        <a href="pages/addNewCourse.jsp">
                            <button class="btn btn-primary">Add New Courses</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
