package com.createvision.wijaya_sports.valuesObject;

public class UserDetailVO {
    private String userName;
    private String password;
    private String role;
    private boolean isSuccess;
    private int roleId;
    private Long userId;
    private String name;

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public boolean isSuccess() {return isSuccess;}
    public void setSuccess(boolean success) {isSuccess = success;}

    public int getRoleId() {return roleId;}
    public void setRoleId(int roleId) {this.roleId = roleId;}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {this.userId = userId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
