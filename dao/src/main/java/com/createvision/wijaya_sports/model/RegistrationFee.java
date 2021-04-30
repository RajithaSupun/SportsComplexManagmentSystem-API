package com.createvision.wijaya_sports.model;

import javax.persistence.*;
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

    @Basic
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public Member getMember() {return member;}
    public void setMember(Member member) {this.member = member;}
}
