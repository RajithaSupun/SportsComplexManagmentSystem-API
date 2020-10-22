package com.createvision.wijaya_sports.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "registration_fee")
public class RegistrationFee extends BaseObject implements Serializable {
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "amount")
    private double amount;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "date")
    private Date date;

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}
}
