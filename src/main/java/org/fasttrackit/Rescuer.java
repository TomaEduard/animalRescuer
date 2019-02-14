package org.fasttrackit;

import java.util.ArrayList;

public class Rescuer {

    private String name;
    private int moneyavaible;

    private ArrayList<String> foodList = new ArrayList<>();

    private int hungerLevel = 10;
    private int happinessLevel = 0;

//

    public Rescuer(String name) {
        this.name = name;
        this.moneyavaible = moneyavaible;
    }

    //

    public void feed(Animal animal, Food food) {
        if (hungerLevel > 1) {
            hungerLevel--;
            System.out.println(this.name + " just gave some " + food.getName() +
                    " to " + animal.getName() + " and now the hunger level is: " + hungerLevel);

            if (animal.getFavoriteFoodName() == food.getName()) {
                happinessLevel++;
                System.out.println("The happiness level is: " + happinessLevel);
            }
        } else {
            System.out.println(animal.getName() + " is no longer hungry.");
        }
    }

    public void walking(Animal animalName, EntertainmentActivity activity) {
        System.out.println(animalName.getName() + " just " + activity.getName() + ".");
    }

    public void entertain(Animal animal, EntertainmentActivity activity) {

        if (animal.getFavoriteActivityName() == activity.getName()) {
            happinessLevel += 2;
            System.out.println(this.name + " just have entertained with " +
                    animal.getName() + " in the " + activity.getName() +
                    " activity, and now the happiness level is: " + happinessLevel);

        } else if (happinessLevel < 10) {
            happinessLevel++;
            System.out.println(this.name + " just have entertained with " +
                    animal.getName() + " in the " + activity.getName() +
                    " activity, and now the happiness level is: " + happinessLevel);
        } else if (happinessLevel >= 10) {
            System.out.println(animal.getName() + " it feels good!");
        }
/*
            if (happinessLevel < 10) {
                happinessLevel++;
                if (animal.getFavoriteActivityName() == activity.getName()) {
                    happinessLevel ++;
                }
                System.out.println(this.name + " just have entertained with " +
                        animal.getName() + " in the " + activity.getName() +
                        " activity, and now the happiness level is: " + happinessLevel);
            }
*/
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
