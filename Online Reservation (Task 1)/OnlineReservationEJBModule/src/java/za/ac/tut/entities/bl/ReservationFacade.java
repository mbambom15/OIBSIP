/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entities.Reservation;

/**
 *
 * @author nhlak
 */
@Stateless
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal {

    @PersistenceContext(unitName = "OnlineReservationEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }

    @Override
    public Reservation findByPnr(Integer pnr) {
        Query query = em.createQuery("SELECT r FROM Reservation r WHERE r.pnr =:pnr");
        query.setParameter("pnr", pnr);
        return (Reservation) query.getSingleResult();
    }

    @Override
    public void deleteByPnr(Integer pnr) {
        Query query = em.createQuery("DELETE FROM Reservation r WHERE r.pnr =:pnr");
        query.setParameter("pnr", pnr);
        query.executeUpdate(); 
    }

}
