package com.createvision.wijaya_sports.valuesObject;

import java.util.Date;

public class PaymentVO {
    private String status;
    private double amount;
    private String date;
    private Long memberId;

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public Long getMemberId() {return memberId;}
    public void setMemberId(Long memberId) {this.memberId = memberId;}
}
