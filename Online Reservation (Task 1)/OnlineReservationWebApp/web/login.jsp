<%-- 
    Document   : login
    Created on : 07 Jun 2025, 1:19:19 PM
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
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <p><%=message%></p>
        <%
            }
        %>
        <h1>Login below.</h1>
        <form action="LoginServelt" method="POST">
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pswd"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="LOGIN"></td>
                </tr>
            </table>
        </form>
        <form action="sign_up.jsp" method="POST">
            <input type="submit" value="SIGNUP">
        </form>
    </body>
</html>
