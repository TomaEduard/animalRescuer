package org.fasttrackit;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Animal implements Runnable {

    private ArrayList<String> food = new ArrayList<>();

    public boolean mood;
    private String name;
    private String color;
    private double age;
    private String gender;
    private String favoriteFoodName;
    private String favoriteActivityName;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);


    public Animal(String name, String color, double age, String gender,
                  String favoriteFoodName, String favoriteActivityName) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
        this.favoriteFoodName = favoriteFoodName;
        this.favoriteActivityName = favoriteActivityName;
        scheduler.scheduleAtFixedRate(this::run, 40, 15, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        food.add("Royal");
        food.add("Amiry");
        food.add("Friskies");
        food.add("Petkult");
        food.add("Enjoy");
        food.add("Green-Point");
        food.add("Herrmanns");
        food.add("N&D");
        food.add("Piccolo");
        food.add("Reddy");

        this.setFavoriteFoodName(food.get(new Random().nextInt(food.size() + 1)));

        Food newFood = new Food(this.favoriteFoodName);
        System.out.println("The Favorite food is now: " + this.getFavoriteFoodName());
    }

//

    public void expressHappiness() {
        System.out.println("No express happiness here");
    }

    public void changeFavoriteFood() {

    }

//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteFoodName() {
        return favoriteFoodName;
    }

    public void setFavoriteFoodName(String favoriteFoodName) {
        this.favoriteFoodName = favoriteFoodName;
    }

    public String getFavoriteActivityName() {
        return favoriteActivityName;
    }

    public void setFavoriteActivityName(String favoriteActivityName) {
        this.favoriteActivityName = favoriteActivityName;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

