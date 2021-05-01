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

    @Basic
    @Column(name = "guest_mobile")
    private String guestMobile;

    @Basic
    @Column(name = "guest_nic")
    private String guestNIC;

    @Basic
    @Column(name = "guest_name")
    private String guestName;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getRemark() {return remark;}
    public void setRemark(String remark) {this.remark = remark;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public String getGuestMobile() {return guestMobile;}

    public void setGuestMobile(String guestMobile) {
        this.guestMobile = guestMobile;
    }

    public String getGuestNIC() {
        return guestNIC;
    }

    public void setGuestNIC(String guestNIC) {
        this.guestNIC = guestNIC;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
