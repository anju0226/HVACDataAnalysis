<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: anju
  Date: 7/8/16
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="Result" class="display table table-bordered" width="100%">
    <thead>
    <tr>
        <th>Building Id</th>
        <th>Modal No</th>
        <th>Expected Data</th>
        <th>Actual Data</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Repo> repoList = (List<Repo>) request.getAttribute("report");
           for(Repo test: repoList){
               out.println("<tr>");
               out.println("<td>"+test.getBuildingId()+"</td>");
              
               out.println("<td>"+test.getModalNo()+"</td>");
               out.println("<td>"+test.getExpectedData()+"</td>");
               out.println("<td>"+test.getActualData()+"</td>");

               out.println("</tr>");

           }
                
     
            out.print("<h1 style='color:red'>No Data Received.</h1>");
        
    %>
    </tbody>
</table>
</body>
</html>
