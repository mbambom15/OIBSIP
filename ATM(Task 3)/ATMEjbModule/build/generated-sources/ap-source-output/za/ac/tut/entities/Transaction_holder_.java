package za.ac.tut.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.AccountHolder;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-08T15:21:27")
@StaticMetamodel(Transaction_holder.class)
public class Transaction_holder_ { 

    public static volatile SingularAttribute<Transaction_holder, Double> amt;
    public static volatile SingularAttribute<Transaction_holder, AccountHolder> holder;
    public static volatile SingularAttribute<Transaction_holder, Long> id;
    public static volatile SingularAttribute<Transaction_holder, String> category;
    public static volatile SingularAttribute<Transaction_holder, Date> creation;

}