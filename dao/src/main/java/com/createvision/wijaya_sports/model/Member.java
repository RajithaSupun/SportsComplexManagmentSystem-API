package com.createvision.wijaya_sports.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member extends BaseObject implements Serializable {

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
    @Column(name = "nic")
    private String nic;

    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Basic
    @Column(name = "join_date")
    private Date joinDate;

    @Basic
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Basic
    @Column(name = "land_number")
    private String landNumber;

    @Enumerated(EnumType.STRING)
    private Sports sports;

    @Basic
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_gender_id")
    private Gender gender;

    @Basic
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_measurement_id")
    private Measurement measurement;

    @Basic
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_registration_fee_id")
    private RegistrationFee registrationFee;

    public String getFirstName() {return firstName; }
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getNic() {return nic;}
    public void setNic(String nic) {this.nic = nic;}

    public Date getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public Date getJoinDate() {return joinDate;}
    public void setJoinDate(Date joinDate) {this.joinDate = joinDate;}

    public String getMobileNumber() {return mobileNumber;}
    public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber;}

    public String getLandNumber() {return landNumber;}
    public void setLandNumber(String landNumber) {this.landNumber = landNumber;}

    public Sports getSports() {return sports;}
    public void setSports(Sports sports) {this.sports = sports;}

    public Gender getGender() {return gender;}
    public void setGender(Gender gender) {this.gender = gender;}

    public Measurement getMeasurement() {return measurement;}
    public void setMeasurement(Measurement measurement) {this.measurement = measurement;}

    public RegistrationFee getRegistrationFee() {return registrationFee;}
    public void setRegistrationFee(RegistrationFee registrationFee) {this.registrationFee = registrationFee;}
}
