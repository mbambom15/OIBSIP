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
import javax.servlet.http.HttpSession;
import za.ac.tut.entities.AccountHolder;
import za.ac.tut.entities.bl.AccountHolderFacadeLocal;

/**
 *
 * @author nhlak
 */
public class HistoryServlet extends HttpServlet {

    @EJB
    AccountHolderFacadeLocal ahfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        AccountHolder hldr = (AccountHolder)session.getAttribute("accountholder");
        Long id = hldr.getId();
        
        AccountHolder accountholder = ahfl.find(id);
        
        
        request.setAttribute("accountholder", accountholder);
        RequestDispatcher disp = request.getRequestDispatcher("historyout.jsp");
        disp.forward(request, response);
    }

}
