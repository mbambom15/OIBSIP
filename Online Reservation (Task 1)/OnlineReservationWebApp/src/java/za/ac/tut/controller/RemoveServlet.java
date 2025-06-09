/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entities.bl.ReservationFacadeLocal;

/**
 *
 * @author nhlak
 */
public class RemoveServlet extends HttpServlet {

    @EJB
    ReservationFacadeLocal rfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer pnr = Integer.parseInt(request.getParameter("pnr"));

        rfl.deleteByPnr(pnr);

        RequestDispatcher disp = request.getRequestDispatcher("remove_out.jsp");
        disp.forward(request, response);

    }

}
