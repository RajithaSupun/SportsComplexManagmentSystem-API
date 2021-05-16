package com.createvision.wijaya_sports.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member_sport")
public class MemberSport extends BaseObject implements Serializable {


    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
