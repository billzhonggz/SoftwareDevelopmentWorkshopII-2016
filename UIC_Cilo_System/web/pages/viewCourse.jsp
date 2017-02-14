<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>View Course - ${c_name}</title>

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
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Change Profile</a>
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
                                <a href="flot.html">Course</a>
                            </li>
                            <li>
                                <a href="morris.html">Qusetion Paper</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="tables.html"><i class="fa fa-table fa-fw"></i> Tables</a>
                    </li>
                    <li>
                        <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="blank.html">Blank Page</a>
                            </li>
                            <li>
                                <a href="login.html">Login Page</a>
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
        session.setAttribute("c_id", request.getParameter("c_id"));
    %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">View Course - ${c_name}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-info">
                    ${message}
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Basic Information
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Course ID in DB</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${c_id}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Course Code</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${c_code}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Course Name</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${c_name}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Instructor ID in DB</strong>
                            </div>
                            <div class="col-lg-6">
                                <p>${c_t_id}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        CILOs of ${c_name}
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
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
                                ArrayList<HashMap<String, String>> ciloInfo = (ArrayList) request.getAttribute("ciloInfo");
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
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                        <%--<%--%>
                        <%--String addCiloBtn = "<a href='/addCilo?c_id=" + request.getParameter("c_id") + "'><button class='btn btn-primary'>Add New CILOs</button></a>";--%>
                        <%--out.print(addCiloBtn);--%>
                        <%--%>--%>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Assessments of ${c_name}
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>ID in DB</th>
                                <th>Assessment Name</th>
                                <th>Type</th>
                                <th>Percentage</th>
                                <th>Detail</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--TODO: Search DB and add AddAssessment information here.--%>
                            <%
                                ArrayList<HashMap<String, String>> assInfo = (ArrayList) request.getAttribute("assInfo");
                                for (int i = 0; i < assInfo.size(); i++) {
                                    HashMap<String, String> row = assInfo.get(i);
                            %>
                            <tr>
                                <td>
                                    <% out.print(row.get("A_ID"));%>
                                </td>
                                <td>
                                    <% out.print(row.get("A_Name"));%>
                                </td>
                                <td>
                                    <%
                                        String A_Type;
                                        switch (row.get("A_Type")) {
                                            case "F":
                                                A_Type = "Final Exam";
                                                break;
                                            case "M":
                                                A_Type = "Midterm Test";
                                                break;
                                            case "Q":
                                                A_Type = "Quiz";
                                                break;
                                            case "A":
                                                A_Type = "Assignment";
                                                break;
                                            default:
                                                A_Type = "N/A";
                                        }
                                        out.print(A_Type);
                                    %>
                                </td>
                                <td>
                                    <% out.print(row.get("Percentage"));%>
                                </td>
                                <td>
                                    <%
                                        String detail = "<a href=\"/showAssDetail?a_id=" + row.get("A_ID") + "\">Detail</a>";
                                        out.print(detail);
                                    %>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                        <%
                            String addAssBtn = "<a href='pages/addAssessment.jsp?c_id=" + request.getParameter("c_id") + "'><button class='btn btn-primary'>Add New Assessments</button></a>";
                            out.print(addAssBtn);
                        %>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Export CILO Report
                    </div>
                    <div class="panel-body">
                        <a href="/createWord?c_id=${c_id}">
                            <button class="btn btn-primary">Click to Output</button>
                        </a>
                        <p>The outputted file will go to your desktop.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
