package com.createvision.wijaya_sports.valuesObject;

public class UserDetailVO {
    private String userName;
    private String password;
    private String role;
    private boolean isSuccess;

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public boolean isSuccess() {return isSuccess;}
    public void setSuccess(boolean success) {isSuccess = success;}
}
