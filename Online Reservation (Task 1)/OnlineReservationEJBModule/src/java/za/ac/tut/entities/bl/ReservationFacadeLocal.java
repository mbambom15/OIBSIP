/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.Reservation;

/**
 *
 * @author nhlak
 */
@Local
public interface ReservationFacadeLocal {

    void create(Reservation reservation);

    void edit(Reservation reservation);

    void remove(Reservation reservation);

    Reservation find(Object id);

    List<Reservation> findAll();

    List<Reservation> findRange(int[] range);

    int count();

    Reservation findByPnr(Integer pnr);

    void deleteByPnr(Integer pnr);

}
