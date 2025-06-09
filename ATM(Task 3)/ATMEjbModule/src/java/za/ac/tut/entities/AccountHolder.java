/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author nhlak
 */
@Entity
public class AccountHolder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "account_number")
    private Long id;
    @Column(name="pin")
    private Integer pin;
    @Column(name = "balance")
    private Double balance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Transaction_holder> transactions;

    public AccountHolder() {
    }

    public AccountHolder(Long id, Integer pin, Double balance, List<Transaction_holder> transactions) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction_holder> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction_holder> transactions) {
        this.transactions = transactions;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountHolder)) {
            return false;
        }
        AccountHolder other = (AccountHolder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entities.AccountHolder[ id=" + id + " ]";
    }
    
}
