package com.allegro.maven.model;
import java.util.List;

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
    public List<Order> getOrdersCompleted() {
        return ordersCompleted;
    }
    public void setOrdersCompleted(List<Order> ordersCompleted) {
        this.ordersCompleted = ordersCompleted;
    }
    public List<Item> getItemsSold() {
        return itemsSold;
    }
    public void setItemsSold(List<Item> itemsSold) {
        this.itemsSold = itemsSold;
    }
    public int getMoneyMade() {
        return moneyMade;
    }
    public void setMoneyMade(int moneyMade) {
        this.moneyMade = moneyMade;
    }
    
}