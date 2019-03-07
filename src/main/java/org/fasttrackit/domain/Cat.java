package org.fasttrackit.domain;

public class Cat extends Animal {

    private String race;
    private String waist;
    private double weight;

    public Cat(String name, String color, double age, String gender, String favoriteFoodName,
               String favoriteActivityName, int hungerLevel, int happinessLevel, String race,
               String waist, double weight) {
        super(name, color, age, gender, favoriteFoodName, favoriteActivityName, hungerLevel, happinessLevel);
        this.race = race;
        this.waist = waist;
        this.weight = weight;
    }

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
        System.out.println(getName() + " purrs. \uD83D\uDE3A");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "race='" + race + '\'' +
                ", waist='" + waist + '\'' +
                ", weight=" + weight +
                "} " + super.toString();
    }
}
