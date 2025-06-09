package za.ac.tut.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entities.Transaction_holder;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-06-08T15:21:27")
@StaticMetamodel(AccountHolder.class)
public class AccountHolder_ { 

    public static volatile SingularAttribute<AccountHolder, Integer> pin;
    public static volatile SingularAttribute<AccountHolder, Double> balance;
    public static volatile SingularAttribute<AccountHolder, Long> id;
    public static volatile ListAttribute<AccountHolder, Transaction_holder> transactions;

}