package com.allegro.maven.model;

public class Courier
{
    private int id;
    private int companyId;
    private String password; // do logowania

    public Courier() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCompanyId() {
        return companyId;
    }
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}