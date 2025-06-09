/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entities.Person;
import za.ac.tut.entities.bl.PersonFacadeLocal;

/**
 *
 * @author nhlak
 */
public class LoginServelt extends HttpServlet {

    @EJB
    PersonFacadeLocal pfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String pswd = request.getParameter("pswd");

        List<Person> allPersonss = pfl.findAll();
        Person person = null;
        Boolean isFound = false;

        for (Person p : allPersonss) {
            if ((p.getId().equals(id)) && p.getPassword().equals(pswd)) {
                isFound = true;
                person = p;
                break;
            }
        }
        if (isFound) {
            HttpSession session = request.getSession();
            session.setAttribute("person", person);

            RequestDispatcher disp = request.getRequestDispatcher("menu.jsp");
            disp.forward(request, response);
        } else {
            request.setAttribute("message", "Invalid username or password");
            RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
            disp.forward(request, response);
        }

    }
}
