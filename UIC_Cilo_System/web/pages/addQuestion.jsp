<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.DavidYao.MySQLAccess" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Question Paper</title>

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
<%
    MySQLAccess DBA = new MySQLAccess();
%>

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

    <%
        String A_ID = null;
        String C_ID = null;
        A_ID = (String) session.getAttribute("A_ID");
        C_ID = (String) session.getAttribute("C_ID");
    %>

    <div id="page-wrapper"> <!-- style="background:#D1E9e9; color:#345" -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Add Question Paper</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel panel-heading">
                        Add Question Here
                    </div>
                    <div class="panel-body">
                        <form method="get" action="/addQuestion">
                            <div class="form-group">
                                <label>Question Number</label>
                                <input type="number" class="form-control" name="Q_Number">
                            </div>
                            <div class="form-group">
                                <label>Question Description</label>
                                <input type="text" class="form-control" name="Q_Description">
                            </div>
                            <div class="form-group">
                                <label>Percentage</label>
                                <input type="number" class="form-control" name="Percentage">
                            </div>
                            <div class="form-group">
                                <label>Question Picture URL</label>
                                <input type="text" class="form-control" name="picUrl">
                            </div>
                            <div class="form-group">
                                <label>Cognitive Level</label>
                                <select>
                                    <option>Knowledge</option>
                                    <option>Comprehension</option>
                                    <option>Application</option>
                                    <option>Analysis</option>
                                    <option>Synthesis</option>
                                    <option>Evaluation</option>
                                </select>
                            </div>

                            <label>Related CILO</label>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>CILO ID</th>
                                    <th>CILO Content</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--TODO: Search DB and insert CILOs--%>
                                <%
                                    ArrayList<HashMap<String, String>> ciloInfo = DBA.readCiloByC_ID(Integer.parseInt(C_ID));
                                    for (int i = 0; i < ciloInfo.size(); i++) {
                                        HashMap<String, String> row = ciloInfo.get(i);
                                %>
                                <tr>
                                    <td>
                                        <% out.print(row.get("CI_ID"));%>
                                    </td>
                                    <td>
                                        <% out.print(row.get("CI_Description"));%>
                                    </td>
                                    <td>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox">Select
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                </tbody>
                            </table>
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- /.col-lg-12 -->
        <!-- /.row -->
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
<style>
    button {
        text-align: center
    }

    .div {
        margin: 0 auto;
        width: 400px;
        height: 100px;
        border: 1px solid #F00;
    }
</style>

</body>

</html>
