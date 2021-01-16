package com.createvision.wijaya_sports.valuesObject;

import java.util.Date;

public class ReservationVO {
    private String firstName;
    private String lastName;
    private String date;
    private String contactNumber;
    private String time;
    private String sport;

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getContactNumber() {return contactNumber;}
    public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}

    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}

    public String getSport() {return sport;}
    public void setSport(String sport) {this.sport = sport;}
}
