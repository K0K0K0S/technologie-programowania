package com.allegro.maven.model;

import java.time.LocalDateTime;

public class Delivery
{
    private int orderId;
    private int curierId;
    private String status; // np. "W trakcie", "Dostarczono"
    private LocalDateTime dateOfDelivery;

    public Delivery() {}

    // Gettery i settery
}