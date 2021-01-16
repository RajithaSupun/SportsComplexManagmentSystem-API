package com.createvision.wijaya_sports.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation extends BaseObject implements Serializable {
    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "contact_number")
    private String contactNumber;

    @Basic
    @Column(name = "time")
    private String time;

    @Basic
    @Column(name = "sport")
    private String sport;

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public String getContactNumber() {return contactNumber;}
    public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}

    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}

    public String getSport() {return sport;}
    public void setSport(String sport) {this.sport = sport;}
}
