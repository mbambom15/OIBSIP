package za.ac.tut.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.Reservation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-07T17:29:37")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> password;
    public static volatile SingularAttribute<Person, String> full_name;
    public static volatile ListAttribute<Person, Reservation> reservations;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Long> id;

}