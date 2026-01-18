package com.allegro.maven.model;

import java.util.Date;

public class CourierInfo
{
    private int id;
    private String name;
    private String surname;
    private double salary;
    private Date dateOfHiring;

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
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Date getDateOfHiring() {
        return dateOfHiring;
    }
    public void setDateOfHiring(Date dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }
    
}