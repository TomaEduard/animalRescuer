package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Food> avaibleFood = new ArrayList<>();
    private EntertainmentActivity[] avaibleActivities = new EntertainmentActivity[2];

    public void start() {
        initFood(2);
        initActivities();

        displayFood();
        displayActivities();
    }

    private void initFood(int avaibleFoodCount) {
        for (int i = 0; i < avaibleFoodCount; i++) {
            Food food1 = new Food("Purina");
            Food food2 = new Food("Pedigree");
            avaibleFood.add(food1);
            avaibleFood.add(food2);
        }
    }

    private void displayFood() {
        System.out.println("The available food is: ");
        for (int i = 0; i < avaibleFood.size(); i++) {
            System.out.println(avaibleFood.get(i).getName());
        }
    }

    private void initActivities() {

        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
        EntertainmentActivity activity2 = new EntertainmentActivity("playing with ball");

        avaibleActivities[0] = activity1;
        avaibleActivities[1] = activity2;
    }

    private void displayActivities() {
        System.out.println("The available activities is: ");
        for (int i = 0; i < avaibleActivities.length; i++) {
            if (avaibleActivities[i] != null) ;
            System.out.println(avaibleActivities[i].getName());
        }
    }

    public EntertainmentActivity activity(int indexNumber) {
        return avaibleActivities[indexNumber];
    }

    public Food food(int index) {
        return avaibleFood.get(index);
    }

    //
    public List<Food> getAvaibleFood() {
        return avaibleFood;
    }

    public void setAvaibleFood(List<Food> avaibleFood) {
        this.avaibleFood = avaibleFood;
    }

    public EntertainmentActivity[] getAvaibleActivities() {
        return avaibleActivities;
    }

    public void setAvaibleActivities(EntertainmentActivity[] avaibleActivities) {
        this.avaibleActivities = avaibleActivities;
    }

}
