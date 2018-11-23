package com.example.dinhdam.uetcourseroom.model;

public class Account {
    private String idAccount;
    private String userName;
    private String password;

    public Account() {
    }

    public Account(String idAccount, String userName, String password) {
        this.idAccount = idAccount;
        this.userName = userName;
        this.password = password;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
