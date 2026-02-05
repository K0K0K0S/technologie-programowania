package com.allegro.maven.model;

public class UserInfo
{
    private int id;
    private String name;
    private String surname;
    private int PESEL;
    private String location;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public int getPESEL() {
        return PESEL;
    }
    
    public void setPESEL(int PESEL) {
        this.PESEL = PESEL;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}