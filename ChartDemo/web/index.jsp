<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: ZHONG
  Date: 2016/9/24
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Chart Demo</title>
  </head>
  <body>
  <%
    String piedata = (String)request.getAttribute("chartData");
    //out.print(piedata);
  %>
  <div id = "chartContainer1"></div>
  </body>
<script src = "asset/canvasjs.min.js"></script>
<script>
    window.onload = function ()
    {
        var chart = new CanvasJS.Chart("chartContainer1",
                {
                    theme: "theme1",
                    title: {
                        text: "Gaming Consoles Sold in 2012"
                    },
                    data: [
                        {
                          type: "pie",
                          showInLegend: true,
                          toolTipContent: "{y} - #percent %",
                          yValueFormatString: "#,##0,,.## Million",
                          legendText: "{indexLabel}",
                          dataPoints:<%out.print(piedata);%>
                        }
                    ]
                });
        chart.render();
    }
</script>
</html>
