<%-- 
    Document   : removeticket
    Created on : 07 Jun 2025, 4:56:12 PM
    Author     : nhlak
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="za.ac.tut.entities.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ticket details below</h1>
        <%
            Reservation rev = (Reservation) request.getAttribute("reservation");
            String fullname = rev.getPerson().getFull_name();
            String train_n = rev.getTrain_name();
            Integer train_number = rev.getT_number();
            String train_class = rev.getTrain_class();
            Date depart = rev.getDeparture();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String departStr = sdf.format(depart);
            String orgin = rev.getStart_place();
            String destination = rev.getDestination();
            Integer pnr = rev.getPnr();
        %>
        <table>
            <tr>
                <td>Full Name : <%=fullname%></td>
                <td>PNR Number: <%=pnr%></td>
                <td>Train name: <%=train_n%></td>
                <td>Train number: <%=train_number%></td>
                <td>Train class: <%=train_class%></td>
                <td>Departure date: <%=departStr%></td>
                <td>Origin point: <%=orgin%></td>
                <td>Destination point: <%=destination%></td>
            </tr>
        </table>
            <form action="RemoveServlet" method="POST">
            <table>
                <tr>
                    <td>To delete ticket: re-enter PNR: </td>
                    <td><input type="text" name="pnr" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="REMOVE"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
