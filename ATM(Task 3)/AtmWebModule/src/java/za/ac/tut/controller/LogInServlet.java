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
import za.ac.tut.entities.AccountHolder;
import za.ac.tut.entities.bl.AccountHolderFacadeLocal;

/**
 *
 * @author nhlak
 */
public class LogInServlet extends HttpServlet {

    @EJB
    AccountHolderFacadeLocal accnHolder;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Integer pin = Integer.parseInt(request.getParameter("pin"));

        List<AccountHolder> holders = accnHolder.findAll();
        AccountHolder accountholder = null;
        Boolean isFound = false;

        for (AccountHolder holder : holders) {
            if ((id.equals(holder.getId())) && pin.equals(holder.getPin())) {
                isFound = true;
                accountholder = holder;
                break;
            }
        }

        if (isFound) {
            HttpSession session = request.getSession();
            session.setAttribute("accountholder", accountholder);
            RequestDispatcher disp = request.getRequestDispatcher("menu.jsp");
            disp.forward(request, response);
        } else {
            request.setAttribute("message", "Invalid accounrt number or pin");
            RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
            disp.forward(request, response);
        }

    }

}
