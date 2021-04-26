package com.createvision.wijaya_sports.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment")
public class Payment extends BaseObject implements Serializable {

    @Basic
    @Column(name = "remark")
    private String remark;

    @Basic
    @Column(name = "amount")
    private double amount;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public String getRemark() {return remark;}
    public void setRemark(String remark) {this.remark = remark;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public Member getMember() {return member;}
    public void setMember(Member member) {this.member = member;}
}
