<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/8/21
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Test - People List</title>
</head>
<body>
    <%!
        int count;
        StringBuffer personList;
        public void judge()
        {
            if (count == 0)
            {
                personList = new StringBuffer();
            }
        }
        public void addPerson(String p)
        {
            if(count == 0)
                personList.append(p);
            else
                personList.append("," + p);
            count++;
        }
    %>
    <%
        String name = request.getParameter("name");
        byte bb[] = name.getBytes("utf-8");
        name = new String(bb);
        if(name.length() == 0 || name.length() > 10)
        { %>
    <jsp:forward page="inputName.jsp"></jsp:forward>
    <%  }
        judge();
        addPerson(name);
    %>
    <br/>
    <p>目前共有<%= count %>人访问了该页面，他们的名字是：</p>
    <br/>
    <%= personList %>
</body>
</html>
