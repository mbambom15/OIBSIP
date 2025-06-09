/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entities.AccountHolder;
import za.ac.tut.entities.Transaction_holder;
import za.ac.tut.entities.bl.AccountHolderFacadeLocal;

/**
 *
 * @author nhlak
 */
public class DepositServlet extends HttpServlet {

    @EJB
    AccountHolderFacadeLocal ahfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Double amt = Double.parseDouble(request.getParameter("amt"));
        //
        if (amt < 0 || amt > 10000) {
            request.setAttribute("message", "Invalid amount / Head to bank for deposits bigger than R10000");
            RequestDispatcher disp = request.getRequestDispatcher("deposit.jsp");
            disp.forward(request, response);
        } else {
            HttpSession session = request.getSession(false);
            AccountHolder hldr =(AccountHolder)session.getAttribute("accountholder");
            
            Double balance = hldr.getBalance();
            Double newBalance = balance + amt;
            //
            hldr.setBalance(newBalance);
            //
            List<Transaction_holder> transactions = hldr.getTransactions();
            //
            String category = "DEPOSIT";
            Date creation = new Date();
            
            Transaction_holder trans = new Transaction_holder(category, creation, hldr, amt);
            
            transactions.add(trans);
            
            hldr.setTransactions(transactions);
            //
            ahfl.edit(hldr);
            //
            request.setAttribute("amt", amt);
            RequestDispatcher disp = request.getRequestDispatcher("depo_out.jsp");
            disp.forward(request, response);
        }
    }

}
