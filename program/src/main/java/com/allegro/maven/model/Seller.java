package com.allegro.maven.model;


public class Seller
{
    private int id;
    private int ordersCompleted;
    private int itemsSold;
    private double moneyMade;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getOrdersCompleted() {
        return ordersCompleted;
    }
    public void setOrdersCompleted(int ordersCompleted) {
        this.ordersCompleted = ordersCompleted;
    }
    public int getItemsSold() {
        return itemsSold;
    }
    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }
    public double getMoneyMade() {
        return moneyMade;
    }
    public void setMoneyMade(double moneyMade) {
        this.moneyMade = moneyMade;
    }
    
}