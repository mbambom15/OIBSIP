<%-- 
    Document   : sign_up
    Created on : 07 Jun 2025, 1:25:08 PM
    Author     : nhlak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up Page</title>
    </head>
    <body>
        <h1>Sign up page</h1>
        <form action="SignUpServlet" method="POST">
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="id" required=""></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="email" name="username" required=""></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pswd" required=""></td>
                </tr>
                <tr>
                    <td>Full name</td>
                    <td><input type="text" name="fname" required=""</td>
                </tr>
                <tr>
                    <td><input type="submit" value="SIGNUP"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
