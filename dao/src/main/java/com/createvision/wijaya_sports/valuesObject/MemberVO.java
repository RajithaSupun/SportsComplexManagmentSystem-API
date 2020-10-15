package com.createvision.wijaya_sports.valuesObject;

public class MemberVO {
    private String firstName;
    private  String lastName;
    private  String address;
    private  String nic;
    private String dateOfBirth;
    private Long genderId;
    private String joinedDate;
    private  int sportsId;
    private String mobileNumber;
    private  String landPhoneNumber;

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

    public int getSportsId() {return sportsId;}
    public void setSportsId(int sportsId) {this.sportsId = sportsId;}

    public String getMobileNumber() {return mobileNumber;}
    public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber;}

    public String getLandPhoneNumber() {return landPhoneNumber;}
    public void setLandPhoneNumber(String landPhoneNumber) {this.landPhoneNumber = landPhoneNumber;}
}
