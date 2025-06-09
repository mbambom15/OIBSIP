<%-- 
    Document   : transfer_out
    Created on : 08 Jun 2025, 4:16:20 PM
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
        <h1>Transfer has been complete.</h1>
        <%
            Integer accNo =(Integer)request.getAttribute("accountnumber");
            Double amt=(Double)request.getAttribute("amt");
        %>
        <p>R <%=amt%> has been transferred to Account Holder: <b><%=accNo%></b></p>
        <p>Click <a href="menu.jsp">here</a> to go back to menu</p>
    </body>
</html>
