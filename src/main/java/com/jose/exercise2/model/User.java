package com.jose.exercise2.model;

public class User {

    private Integer userId;
    private String username, salt, password, firstName, lastName;

    public User(Integer userId, String username, String salt, String password, String firstName, String lastName) {
        this.userId = userId;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getUserid() {
        return userId;
    }

    public void setUserid(Integer userid) {
        this.userId = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return firstName;
    }

    public void setFname(String fname) {
        this.firstName = fname;
    }

    public String getLname() {
        return lastName;
    }

    public void setLname(String lname) {
        this.lastName = lname;
    }

}
