package com.allegro.maven.model;

import java.time.LocalDateTime;

public class Delivery
{
    private int orderId;
    private int courierId;
    private String status; // np. "W trakcie", "Dostarczono"
    private LocalDateTime dateOfDelivery;

    public Delivery() {}

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getCourierId() {
        return courierId;
    }
    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getDateOfDelivery() {
        return dateOfDelivery;
    }
    public void setDateOfDelivery(LocalDateTime dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }
    
}