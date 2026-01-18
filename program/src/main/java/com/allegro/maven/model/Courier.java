package com.allegro.maven.model;

public class Courier
{
    private int id;
    private int companyId;
    private String password; // do logowania
    private String name;
    private String surname;
    private double salary;

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
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}