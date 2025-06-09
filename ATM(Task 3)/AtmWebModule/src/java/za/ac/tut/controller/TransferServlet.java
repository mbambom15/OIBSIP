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
public class TransferServlet extends HttpServlet {

    @EJB
    AccountHolderFacadeLocal ahfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer accountnumber = Integer.parseInt(request.getParameter("accnno"));
        Double amt = Double.parseDouble(request.getParameter("amt"));
        
        HttpSession session = request.getSession(false);
        AccountHolder hldr = (AccountHolder)session.getAttribute("accountholder");
        Double balance = hldr.getBalance();
        
        if(amt < 0 || amt > balance){
            request.setAttribute("message", "Invalid amount / Insufficient balance");
            RequestDispatcher disp = request.getRequestDispatcher("transfer.jsp");
            disp.forward(request, response);
        }else{
            Double newbalance = balance - amt;
            //
            hldr.setBalance(newbalance);
            //
            List<Transaction_holder> trans = hldr.getTransactions();
            //
            String category = "TRANSFER";
            Date creation = new Date();
            //
            Transaction_holder th = new Transaction_holder(category, creation, hldr, amt);
            //
            trans.add(th);
            //
            hldr.setTransactions(trans);
            //
            ahfl.edit(hldr);
            //
            request.setAttribute("accountnumber", accountnumber);
            request.setAttribute("amt", amt);
            RequestDispatcher disp = request.getRequestDispatcher("transfer_out.jsp");
            disp.forward(request, response);
        }
    }

}
