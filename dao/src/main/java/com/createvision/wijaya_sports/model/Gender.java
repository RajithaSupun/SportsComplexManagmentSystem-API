package com.createvision.wijaya_sports.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "gender")
public class Gender extends BaseObject implements Serializable {
    @Basic
    @Column(name = "gender_Name")
    private String genderName;

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
