<%-- 
    Document   : create_outcome
    Created on : 07 Jun 2025, 2:31:05 PM
    Author     : nhlak
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Reservation"%>
<%@page import="za.ac.tut.entities.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <%
            Person p = (Person) request.getAttribute("person");
            String fullname = p.getFull_name();
            List<Reservation> rev = p.getReservations();
        %>
        <h1>Reservation has been created.</h1>
        <table>
            <tr>
                <th>Full name: </th>
            </tr>
            <tr>
                <td><%=fullname%></td>
            </tr>
        </table>
        <table>
            <th>Train name:</th>
            <th>Train number</th>
            <th>Train Class</th>
            <th>Date of departure</th>
            <th>Startin point</th>
            <th>Ending point</th>
            <th>PNR Number</th>
                <%
                    for (Reservation r : rev) {
                        String train_name = r.getTrain_name();
                        Integer train_number = r.getT_number();
                        String t_class = r.getTrain_class();
                        Date departure = r.getDeparture();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String departureStr = sdf.format(departure);
                        String orgin = r.getStart_place();
                        String dest = r.getDestination();
                        Integer pnr = r.getPnr();
                %>
            <tr>
                <td><%=train_name%></td>
                <td><%=train_number%></td>
                <td><%=t_class%></td>
                <td><%=departureStr%></td>
                <td><%=orgin%></td>
                <td><%=dest%></td>
                <td><%=pnr%></td>
            </tr>

            <%
                }
            %>
        </table>
        <p>To go back to <a href="menu.jsp">menu</a></p>

    </body>
</html>
