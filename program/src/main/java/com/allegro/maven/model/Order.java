package com.allegro.maven.model;

import java.time.LocalDateTime;

public class Order
{
    private int id;
    private int itemId;
    private int buyerId;
    private int sellerId;
    private double cost;
    private LocalDateTime dateOfOrder;

    public Order() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }
    public int getSellerId() {
        return sellerId;
    }
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }
    public void setDateOfOrder(LocalDateTime dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}