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
public class WithdrawServlet extends HttpServlet {

    @EJB
    AccountHolderFacadeLocal ahfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Double amt = Double.parseDouble(request.getParameter("amt"));
        HttpSession session = request.getSession(false);
        //find the accountholder in the session
        AccountHolder accnHld = (AccountHolder)session.getAttribute("accountholder");
        Double balance = accnHld.getBalance();
        //check if the withdraw amt is bigger than available and that
        Double newBalance;
        if(amt > balance || amt < 0){
            request.setAttribute("message", "Balance insufficient / Invalid request amount");
            RequestDispatcher disp = request.getRequestDispatcher("withdraw.jsp");
            disp.forward(request, response);
        }else{
            newBalance = balance - amt;
            //edit the balance and add transaction
            accnHld.setBalance(newBalance);
            //get the list of transactions
            List<Transaction_holder> transactions = accnHld.getTransactions();
            Date creation = new Date();
            String transaction = "WITHDRAW";
            Transaction_holder tran = new Transaction_holder(transaction, creation, accnHld,amt);
            tran.setHolder(accnHld);
            transactions.add(tran);
            
            //
            accnHld.setTransactions(transactions);
            //
            ahfl.edit(accnHld);
            
            
            request.setAttribute("amt", amt);
            RequestDispatcher disp = request.getRequestDispatcher("withdraw_outcome.jsp");
            disp.forward(request, response);
        }
        
        
        

    }

}
