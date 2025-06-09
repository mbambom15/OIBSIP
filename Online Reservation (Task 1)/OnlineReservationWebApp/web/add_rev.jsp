<%-- 
    Document   : add_rev
    Created on : 07 Jun 2025, 2:05:15 PM
    Author     : nhlak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add reservation page</title>
    </head>
    <body>
        <h1>Add reservation details</h1>
        <form action="CreateServlet" method="POST">
            <table>
                <tr>
                    <td>Train name: </td>
                    <td><input type="text" name="t_name" value="Gautrain" readonly=""</td>
                </tr>
                <tr>
                    <td>Train number: </td>
                    <td><input type="text" name="t_num" value="1307" readonly=""</td>
                </tr>
                <tr>
                    <td>Class type</td>
                    <td>
                        <select name="classT">
                            <option value="firstC">First Class</option>
                            <option value="secondC">Second Class</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Departure Day: </td>
                    <td><input type="date" name="d_date" required=""</td>
                </tr>
                <tr>
                    <td>Starting point: </td>
                    <td><input type="text" name="s_point"</td>
                </tr>
                <tr>
                    <td>Destination: </td>
                    <td><input type="text" name="d_point"</td>
                </tr>
                <tr>
                    <td><input type="submit" value="CREATE"</td>
                </tr>
            </table>
        </form>
    </body>
</html>
