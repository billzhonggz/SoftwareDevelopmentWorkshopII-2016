<%@ page import="com.DavidYao.MySQLAccess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/10/21
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Assessment - ID ${A_ID}</title>

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

    <%
        String T_ID = null;
        String C_ID = null;
        String A_ID = null;
        T_ID = (String)session.getAttribute("T_ID");
        session.setAttribute("T_ID", T_ID);
        C_ID = (String)session.getAttribute("C_ID");
        session.setAttribute("C_ID", C_ID);
        A_ID = request.getParameter("A_ID");
        if(A_ID == null)
            A_ID = (String)session.getAttribute("A_ID");
        session.setAttribute("A_ID", A_ID);

        //C_ID = "25";
        //A_ID = "1";//Temperary Fake

        ArrayList<HashMap<String, String>> alrs = new ArrayList<>();
        MySQLAccess DBA = new MySQLAccess();

        String A_Name = null;
        String A_Type = null;
        int Percentage = 0;
        alrs = DBA.readAssessmentByA_ID(Integer.parseInt(A_ID));
        A_Name = alrs.get(0).get("A_Name");
        A_Type = alrs.get(0).get("A_Type");
        Percentage = Integer.parseInt(alrs.get(0).get("Percentage"));
    %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">View Assessment - ID <%=A_ID%></h1>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-info">
                    ${message}
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Basic Information
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Assessment ID in DB</strong>
                            </div>
                            <div class="col-lg-6">
                                <p><%=A_ID%></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Assessment Type</strong>
                            </div>
                            <div class="col-lg-6">
                                <p><%=A_Type%></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Assessment Name</strong>
                            </div>
                            <div class="col-lg-6">
                                <p><%=A_Name%></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <strong>Assessment Percentage</strong>
                            </div>
                            <div class="col-lg-6">
                                <p><%=Percentage%>%</p>
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
                        Questions of <%=A_Name%> (ID: <%=A_ID%>})
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Question ID in DB</th>
                                <th>Question Description</th>
                                <th>Picuture (If Any)</th>
                                <th>Percentage</th>
                                <th>Cognitive Level</th>
                                <th>Related CILO ID</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                int mQ_Number = DBA.readMQ_Number(Integer.parseInt(A_ID));
                                int Q_ID = 0;
                                int Q_Percentage = 0;
                                for (int i = 1; i <= mQ_Number; i++) {
                                    alrs = DBA.readA_QByA_IDQ_Number(Integer.parseInt(A_ID), i);
                                    Q_ID = Integer.parseInt(alrs.get(0).get("Q_ID"));
                                    Q_Percentage = Integer.parseInt(alrs.get(0).get("Percentage"));
                                    String Q_Description = null;
                                    String picUrl = null;
                                    alrs = null;
                                    alrs = DBA.readQuestionByQ_ID(Q_ID);
                                    //System.out.println(alrs);
                                    Q_Description = alrs.get(0).get("Q_Description");
                                    picUrl = alrs.get(0).get("picUrl");
                                    String cogLevel = null;
                                    alrs = DBA.readCogLevelByQ_ID(Q_ID);
                                    cogLevel = alrs.get(0).get("cogLevel");
                                    System.out.println(alrs);
                                    int CI_ID = 0;
                                    alrs = DBA.readQ_CIByQ_ID(Q_ID);
                                    System.out.println(alrs);
                                    CI_ID = Integer.parseInt(alrs.get(0).get("CI_ID"));
                            %>
                            <tr>
                                <td><%=Q_ID%>
                                </td>
                                <td><%=Q_Description%>
                                </td>
                                <td><%=picUrl%>
                                </td>
                                <td><%=Q_Percentage%>
                                </td>
                                <td><%=cogLevel%>
                                </td>
                                <td><%=CI_ID%>
                                </td>
                                <td>
                                    <form>
                                        <input type="hidden" name="Q_ID" value="<%= Q_ID%>">
                                        <input type="submit" name="editQuestion" value="Edit Question">
                                        <input type="submit" name="delete" value="Delete">
                                    </form>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                            </tbody>
                        </table>
                        <a href="pages/addQuestion.jsp?a_id=${A_ID}">
                            <button class="btn btn-primary">Add a New Question</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Upload Excel Sheet for Students' Performance
                    </div>
                    <div class="panel-body">
                        <a href="/pages/importData.jsp">
                            <button class="btn btn-danger">To Import Excel Page</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
