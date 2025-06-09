package za.ac.tut.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-07T17:29:37")
@StaticMetamodel(Reservation.class)
public class Reservation_ { 

    public static volatile SingularAttribute<Reservation, Integer> t_number;
    public static volatile SingularAttribute<Reservation, Integer> pnr;
    public static volatile SingularAttribute<Reservation, String> train_name;
    public static volatile SingularAttribute<Reservation, Person> person;
    public static volatile SingularAttribute<Reservation, String> destination;
    public static volatile SingularAttribute<Reservation, String> start_place;
    public static volatile SingularAttribute<Reservation, Long> id;
    public static volatile SingularAttribute<Reservation, Date> departure;
    public static volatile SingularAttribute<Reservation, String> train_class;

}