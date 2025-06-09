<%-- 
    Document   : login
    Created on : 08 Jun 2025, 2:13:39 PM
    Author     : nhlak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
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
        <h1>Enter your details below</h1>
        <form action="LogInServlet" method="POST">
            <table>
                <tr>
                    <td>Account number</td>
                    <td><input type="text" name="id" required=""></td>
                </tr>
                <tr>
                    <td>PIN</td>
                    <td><input type="password" name="pin" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="LOGIN"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
