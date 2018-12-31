package org.fasttrackit;

public class Treatment extends Veterinarian {


    private int duration;
    private double cost;


    public Treatment(String name) {
        super(name);
    }

//


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
