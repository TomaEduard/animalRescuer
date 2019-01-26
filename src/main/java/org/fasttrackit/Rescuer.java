package org.fasttrackit;

public class Rescuer {

    private String name;
    private int moneyavaible;

    private int hungerLevel = 10;
    private int happinessLevel = 0;

//

    public Rescuer(String name, int moneyavaible) {
        this.name = name;
        this.moneyavaible = moneyavaible;
    }

    //


    public void feed(String animal, String food) {

        if (hungerLevel > 1) {
            hungerLevel--;
            System.out.println(this.name + " just gave some " +
                    food + " to " + animal + "and now the hunger level is: " + hungerLevel);
        } else {
            System.out.println(animal + " feels the village!");
        }
    }

    public void entertain(String animal, RecreationActivity recreationActivity) {
        if (happinessLevel < 10) {
            happinessLevel++;
        }

        System.out.println(this.name + " just have entertained with " +
                 animal + " in the " + recreationActivity.getName() +
                " activity, and now the happiness level is: " + happinessLevel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneyavaible() {
        return moneyavaible;
    }

    public void setMoneyavaible(int moneyavaible) {
        this.moneyavaible = moneyavaible;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }
}
