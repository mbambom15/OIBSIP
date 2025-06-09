<%-- 
    Document   : menu
    Created on : 08 Jun 2025, 2:35:43 PM
    Author     : nhlak
--%>

<%@page import="za.ac.tut.entities.AccountHolder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu page</title>
    </head>
    <body>
        <%
            AccountHolder holder =(AccountHolder)session.getAttribute("accountholder");
            Double balance = holder.getBalance();
        %>
        <h1>Welcome to the menu. Available balance is: R<%=balance%> </h1>
        <form action="HistoryServlet" method="GET">
            <input type="submit" value="Transactions History">
        </form>
        <ul>
            <li><a href="withdraw.jsp">Withdraw</a></li>
            <li><a href="deposit.jsp">Deposit</a></li>
            <li><a href="transfer.jsp">Transfer</a></li>
        </ul>
        <form action="LogoutServlet" method="GET">
            <input type="submit" value="QUIT">
        </form>
    </body>
</html>
