package com.createvision.wijaya_sports.valuesObject;

public class EmployeeVO {
    private Long id;
    private String firstName;
    private  String lastName;
    private  String address;
    private String dateOfBirth;
    private  String nic;
    private Long genderId;
    private String genderName;
    private String joinedDate;
    private String designation;
    private String mobileNumber;
    private  String landPhoneNumber;
    private String userName;
    private String password;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address; }

    public String getDateOfBirth() {return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth; }

    public String getNic() {return nic; }
    public void setNic(String nic) {this.nic = nic; }

    public Long getGenderId() {return genderId;}
    public void setGenderId(Long genderId) {this.genderId = genderId; }

    public String getGenderName() {return genderName;}
    public void setGenderName(String genderName) {this.genderName = genderName; }

    public String getJoinedDate() {return joinedDate; }
    public void setJoinedDate(String joinedDate) {this.joinedDate = joinedDate; }

    public String getDesignation() {return designation;}
    public void setDesignation(String designation) {this.designation = designation; }

    public String getMobileNumber() {return mobileNumber;}
    public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber; }

    public String getLandPhoneNumber() {return landPhoneNumber;}
    public void setLandPhoneNumber(String landPhoneNumber) {this.landPhoneNumber = landPhoneNumber;}


    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
