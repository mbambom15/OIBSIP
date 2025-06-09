<%-- 
    Document   : withdraw_outcome
    Created on : 08 Jun 2025, 3:21:54 PM
    Author     : nhlak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Double amt = (Double) request.getAttribute("amt");
        %>
        <h1>Successfully withdrawn :R<%=amt%></h1>
        <p><a href="menu.jsp">Click here to go back to menu.</a></p>
    </body>
</html>
