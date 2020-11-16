package com.expensetracker.core.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movements")
public class Movements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;
    @Column(name = "AMOUNT")
    Integer amount;
    @Column(name = "DATE")
    Date date;

    //Getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
