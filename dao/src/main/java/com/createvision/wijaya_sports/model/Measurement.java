package com.createvision.wijaya_sports.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "measurement")
public class Measurement extends BaseObject implements Serializable {

    @Basic
    @Column(name = "chest")
    private String chest;
    @Basic
    @Column(name = "left_arm")
    private String lestArm;
    @Basic
    @Column(name = "abdomen")
    private String abdomen;
    @Basic
    @Column(name = "left_thigh")
    private String leftThigh;
    @Basic
    @Column(name = "left_calf")
    private String leftCalf;
    @Basic
    @Column(name = "wrist")
    private String wrist;
    @Basic
    @Column(name = "right_arm")
    private String rightArm;
    @Basic
    @Column(name = "hips")
    private String hips;
    @Basic
    @Column(name = "right_thigh")
    private String rightThigh;
    @Basic
    @Column(name = "right_calf")
    private String rightCalf;


    public String getChest() {return chest;}
    public void setChest(String chest) {this.chest = chest;}

    public String getLestArm() {return lestArm;}
    public void setLestArm(String lestArm) {this.lestArm = lestArm;}

    public String getAbdomen() {return abdomen;}
    public void setAbdomen(String abdomen) {this.abdomen = abdomen;}

    public String getLeftThigh() {return leftThigh;}
    public void setLeftThigh(String leftThigh) {this.leftThigh = leftThigh;}

    public String getLeftCalf() {return leftCalf;}
    public void setLeftCalf(String leftCalf) {this.leftCalf = leftCalf;}

    public String getWrist() {return wrist;}
    public void setWrist(String wrist) {this.wrist = wrist;}

    public String getRightArm() {return rightArm;}
    public void setRightArm(String rightArm) {this.rightArm = rightArm;}

    public String getHips() {return hips;}
    public void setHips(String hips) {this.hips = hips;}

    public String getRightThigh() {return rightThigh;}
    public void setRightThigh(String rightThigh) {this.rightThigh = rightThigh;}

    public String getRightCalf() {return rightCalf;}
    public void setRightCalf(String rightCalf) {this.rightCalf = rightCalf;}

}
