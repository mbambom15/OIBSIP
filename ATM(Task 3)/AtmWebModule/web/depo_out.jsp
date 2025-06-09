<%-- 
    Document   : depo_out
    Created on : 08 Jun 2025, 3:45:23 PM
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
            Double amt = (Double)request.getAttribute("amt");
        %>
        <h1>Deposit has been done successfully. </h1>
        <h3>Amount :R<%=amt%></h3>
        <p>Click <a href="menu.jsp">here</a> to go back home</p>
    </body>
</html>
