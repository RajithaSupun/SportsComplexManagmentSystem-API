package com.createvision.wijaya_sports.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee extends BaseObject implements Serializable {


    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Basic
    @Column(name = "nic")
    private String nic;


    @Basic
    @Column(name = "join_date")
    private Date join_Date;

    @Basic
    @Column(name = "mobile_number")
    private String mobile_Number;

    @Basic
    @Column(name = "landphone_number")
    private String landphone_Number;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    @JsonIgnore
    private Gender gender;

    @Basic
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Gender getGender() {return gender; }
    public void setGender(Gender gender) {this.gender = gender;}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoin_Date() {
        return join_Date;
    }
    public void setJoin_Date(Date join_Date) {
        this.join_Date = join_Date;
    }

    public String getMobile_Number() {
        return mobile_Number;
    }
    public void setMobile_Number(String mobile_Number) {
        this.mobile_Number = mobile_Number;
    }

    public String getLandphone_Number() {
        return landphone_Number;
    }
    public void setLandphone_Number(String landphone_Number) {
        this.landphone_Number = landphone_Number;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}

