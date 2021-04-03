package com.createvision.wijaya_sports.valuesObject;

import java.sql.Date;

public class RegistrationFeeVO {
    private double amount;
    private String date;
    private String description;
    private int status;

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}
}
