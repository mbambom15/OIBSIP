/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entities.Person;
import za.ac.tut.entities.Reservation;
import za.ac.tut.entities.bl.PersonFacadeLocal;

/**
 *
 * @author nhlak
 */
public class CreateServlet extends HttpServlet {

    @EJB
    PersonFacadeLocal pfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String train_name = request.getParameter("t_name");
            Integer train_number = Integer.parseInt(request.getParameter("t_num"));
            String classType = request.getParameter("classT");

            String dateStr = request.getParameter("d_date");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date departure = sdf.parse(dateStr);
            String s_point = request.getParameter("s_point");
            String dest = request.getParameter("d_point");

            Random rand = new Random();
            Integer min = 10000;
            Integer max = 99999;
            Integer pnr = rand.nextInt((max - min + 1) + min);
            //
            HttpSession session = request.getSession(false);
            Person person = (Person) session.getAttribute("person");
            //
            Reservation reservation = new Reservation();
            reservation.setTrain_name(train_name);
            reservation.setT_number(train_number);
            reservation.setTrain_class(classType);
            reservation.setDeparture(departure);
            reservation.setStart_place(s_point);
            reservation.setDestination(dest);
            reservation.setPnr(pnr);
            reservation.setPerson(person);
            
            //
            List<Reservation> rev = person.getReservations();
            //
            rev.add(reservation);
            //
            person.setReservations(rev);
            //
            pfl.edit(person);
            //

            request.setAttribute("person", person);
            RequestDispatcher disp = request.getRequestDispatcher("create_outcome.jsp");
            disp.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
