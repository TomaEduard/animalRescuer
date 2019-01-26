package org.fasttrackit;

public class Dog extends Animal {

    private String race;
    private String waist;
    private double weight;


    public Dog(String name, String color, double age, String gender) {
        super(name, color, age, gender);
    }
//


//

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public void expressHappiness() {
        System.out.println(getName() + " quits. \uD83D\uDC36 ");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "race='" + race + '\'' +
                ", waist='" + waist + '\'' +
                ", weight=" + weight +
                "} " + super.toString();
    }
}
