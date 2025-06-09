<%-- 
    Document   : historyout
    Created on : 08 Jun 2025, 4:32:11 PM
    Author     : nhlak
--%>

<%@page import="java.util.Date"%>
<%@page import="za.ac.tut.entities.Transaction_holder"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.AccountHolder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>History Outcome</h1>
        <%
            AccountHolder accountHolder = (AccountHolder) request.getAttribute("accountholder");
            Long id = accountHolder.getId();
            Double balance = accountHolder.getBalance();

            List<Transaction_holder> transactions = accountHolder.getTransactions();
        %>
        <table bordr="1">
            <th>Account number: </th>
            <th>Account balance: </th>
            <tr>
                <td><%=id%></td>
                <td>R<%=balance%></td>
            </tr>
        </table>
        <table border="1">
            <th>Category: </th>
            <th>Date of transaction: </th>
            <th>Amount of money: </th>
                <%
                    for (Transaction_holder t : transactions) {
                        String category = t.getCategory();
                        Date creation = t.getCreation();
                        Double money = t.getAmt();
                %>
            <tr>
                <td><%=category%></td>
                <td><%=creation%></td>
                <td>R<%=money%></td>
            </tr>
            <%
                }
            %>
        </table>
        <form action="LogoutServlet" method="GET">
            <input type="submit" value="QUIT">
        </form>
        <p>To go home. Click <a href="menu.jsp">here</a></p>
    </body>
</html>
