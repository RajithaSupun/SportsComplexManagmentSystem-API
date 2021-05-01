package com.createvision.wijaya_sports.valuesObject;

import java.util.List;

public class MemberVO {
    private Long memberId;
    private String firstName;
    private  String lastName;
    private  String address;
    private  String nic;
    private String dateOfBirth;
    private Long genderId;
    private String joinedDate;
    private int sportId;
    private String mobileNumber;
    private  String landPhoneNumber;
    private String sportName;
    private List<MeasurementVO> measurement;
    private List<RegistrationFeeVO> registrationFee;
    private List<SportVO> sportsIdList;



    public Long getMemberId() {return memberId;}
    public void setMemberId(Long memberId) {this.memberId = memberId;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getNic() {return nic;}
    public void setNic(String nic) {this.nic = nic;}

    public String getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public Long getGenderId() {return genderId;}
    public void setGenderId(Long genderId) {this.genderId = genderId;}

    public String getJoinedDate() {return joinedDate;}
    public void setJoinedDate(String joinedDate) {this.joinedDate = joinedDate;}

    public int getSportId() {return sportId;}
    public void setSportId(int sportId) {this.sportId = sportId;}

    public String getMobileNumber() {return mobileNumber;}
    public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber;}

    public String getLandPhoneNumber() {return landPhoneNumber;}
    public void setLandPhoneNumber(String landPhoneNumber) {this.landPhoneNumber = landPhoneNumber;}

    public String getSportName() {return sportName;}
    public void setSportName(String sportName) {this.sportName = sportName;}

    public List<MeasurementVO> getMeasurement() {return measurement;}
    public void setMeasurement(List<MeasurementVO> measurement) {this.measurement = measurement;}

    public List<RegistrationFeeVO> getRegistrationFee() {return registrationFee;}
    public void setRegistrationFee(List<RegistrationFeeVO> registrationFee) {this.registrationFee = registrationFee;}

    public List<SportVO> getSportsIdList() {
        return sportsIdList;
    }

    public void setSportsIdList(List<SportVO> sportsIdList) {
        this.sportsIdList = sportsIdList;
    }
}
