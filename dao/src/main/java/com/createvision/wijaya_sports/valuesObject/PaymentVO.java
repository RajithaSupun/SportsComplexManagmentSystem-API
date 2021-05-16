package com.createvision.wijaya_sports.valuesObject;

import java.util.Date;

public class PaymentVO {
    private String status;
    private double amount;
    private String date;
    private Long memberId;
    private String name;
    private String guestMobile;
    private String guestNIC;
    private String guestName;
    private Long id;

    public int getPaymentCounter() {
        return paymentCounter;
    }

    public void setPaymentCounter(int paymentCounter) {
        this.paymentCounter = paymentCounter;
    }

    private int paymentCounter;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public Long getMemberId() {return memberId;}
    public void setMemberId(Long memberId) {this.memberId = memberId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getGuestMobile() {
        return guestMobile;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
