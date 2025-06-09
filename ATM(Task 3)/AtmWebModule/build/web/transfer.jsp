<%-- 
    Document   : transfer
    Created on : 08 Jun 2025, 3:49:24 PM
    Author     : nhlak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
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
        <h1>Transfer. Enter the amount and account details</h1>
        <form action="TransferServlet" method="POST">
            <table>
                <tr>
                    <td>Account number: </td>
                    <td><input type="text" name="accnno" required=""></td>
                </tr>
                <tr>
                    <td>Amount :R</td>
                    <td><input type="text" name="amt" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Transfer"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
