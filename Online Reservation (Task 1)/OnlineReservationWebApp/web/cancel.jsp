<%-- 
    Document   : cancel
    Created on : 07 Jun 2025, 4:46:28 PM
    Author     : nhlak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Page</title>
    </head>
    <body>
        <%
            String message = (String)request.getAttribute("message");
            if(message != null){
                %>
                <p><%=message%>+</p>
                <%
            }
        %>
        <h1>Enter your PNR ticket number</h1>
        <form action="FindServelt" method="POST">
            <table>
                <tr>
                    <td>PNR number: </td>
                    <td><input type="text" name="pnr" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="FIND ticket"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
