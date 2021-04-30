package com.createvision.wijaya_sports.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class GuestPayment extends BaseObject implements Serializable {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "amount")
    private double amount;
    @Basic
    @Column(name = "remark")
    private String remark;
    @Basic
    @Column(name = "date")
    private Date date;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getRemark() {return remark;}
    public void setRemark(String remark) {this.remark = remark;}
}
