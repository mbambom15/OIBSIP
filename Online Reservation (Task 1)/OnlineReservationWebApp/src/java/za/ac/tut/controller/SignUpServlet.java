/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entities.Person;
import za.ac.tut.entities.Reservation;
import za.ac.tut.entities.bl.PersonFacadeLocal;

/**
 *
 * @author nhlak
 */
public class SignUpServlet extends HttpServlet {

    @EJB
    PersonFacadeLocal pfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("pswd");
        String fullname = request.getParameter("fname");
        //
        List<Reservation> reservations = new ArrayList<>();
        //
        Person person = new Person(id, username, password, fullname, reservations);
        //
        pfl.create(person);
        String message ="succesfull sign_up.";
        
        request.setAttribute("message", message);
        RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
        disp.forward(request, response);

    }

}
