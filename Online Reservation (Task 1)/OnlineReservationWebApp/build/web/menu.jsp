<%-- 
    Document   : menu
    Created on : 07 Jun 2025, 2:00:48 PM
    Author     : nhlak
--%>

<%@page import="za.ac.tut.entities.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <%
            Person p = (Person)session.getAttribute("person");
            String name = p.getFull_name();
        %>
        <h1>Welcome to our reservation system: <%=name%></h1>
        <h3>Menu</h3>
        <ul>
            <li><a href="add_rev.jsp">Create Reservation</a></li>
            <li><a href="cancel.jsp">Cancel Reservation</a></li>
        </ul>
        <form action="LogoutServlet" method="GET">
            <input type="submit" value="LOGOUT">
        </form>
    </body>
</html>
