package org.fasttrackit;

import java.time.LocalDateTime;


public class AnimalFood{

    private String name;
    private double price;
    private int amount;
    private LocalDateTime expiryDate;
    private String Availability;

    public AnimalFood(String name, double price) {
        this.name = name;
        this.price = price;
    }

//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }



}
