package com.ags.wallettest.helper;

public class User {
    public String userKey;
    public String userName;
    public String userEmail;
    public String password;

    public User() {
    }

    public User(String userKey, String userName, String userEmail, String password) {
        this.userKey = userKey;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public User(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
