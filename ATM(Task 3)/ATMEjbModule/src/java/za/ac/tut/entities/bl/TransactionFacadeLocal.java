/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.Transaction_holder;

/**
 *
 * @author nhlak
 */
@Local
public interface TransactionFacadeLocal {

    void create(Transaction_holder transaction);

    void edit(Transaction_holder transaction);

    void remove(Transaction_holder transaction);

    Transaction_holder find(Object id);

    List<Transaction_holder> findAll();

    List<Transaction_holder> findRange(int[] range);

    int count();
    
}
