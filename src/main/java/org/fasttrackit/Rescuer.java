package org.fasttrackit;

import org.fasttrackit.domain.Animal;

import java.util.ArrayList;

public class Rescuer {

    private String name;
    private int moneyavaible;
    Game game;
    private ArrayList<String> foodList = new ArrayList<>();

    int hungerLevel = 0;
    int happinessLevel = 0;

//

    public Rescuer(String name) {
        this.name = name;
    }

//

    public void feed(Animal animal, Food food) {
        if (hungerLevel >= 1) {
            hungerLevel--;
            System.out.println(this.name + " just gave some " + food.getName() +
                    " to " + animal.getName() + " and now the hunger level is: " + hungerLevel + "/10 \uD83C\uDF57");

            if (animal.getFavoriteFoodName().equals(food.getName())) {
                happinessLevel++;
                System.out.println("The happiness level is: " + happinessLevel + "/10 \uD83D\uDE0A");
            }
        } else {
            System.out.println(animal.getName() + " is no longer hungry.");
        }
        animal.expressHappiness();
        System.out.println("Press any key to go back to Menu");

    }

    public void entertain(Animal animal, EntertainmentActivity activity) {
        if (animal.getFavoriteActivityName().equals( activity.getName())) {
            happinessLevel += 2;
            System.out.println(this.name + " just have entertained with " +
                    animal.getName() + " in the " + activity.getName() +
                    " activity, and now the happiness level is: " + happinessLevel + "/10 \uD83D\uDE0A");
        } else if (happinessLevel < 10) {
            happinessLevel++;
            System.out.println(this.name + " just have entertained with " +
                    animal.getName() + " in the " + activity.getName() +
                    " activity, and now the happiness level is: " + happinessLevel + "/10 \uD83D\uDE0A");
        } else if (happinessLevel == 10) {
            animal.expressHappiness();
        }
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
