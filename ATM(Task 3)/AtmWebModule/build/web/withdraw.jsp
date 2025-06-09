<%-- 
    Document   : withdraw
    Created on : 08 Jun 2025, 2:45:43 PM
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
            String message = (String)request.getAttribute("message");
            if(message != null){
                %>
                <p><%=message%></p>
                <%
            }
        %>
        <h1>Withdraw</h1>
        <form action="WithdrawServlet" method="POST">
            <table>
                <tr>
                    <td>Amount :R</td>
                    <td><input type="text" name="amt" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="WITHDRAW"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
