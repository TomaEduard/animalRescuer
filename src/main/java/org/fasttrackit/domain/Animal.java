package org.fasttrackit.domain;

import org.fasttrackit.EntertainmentActivity;
import org.fasttrackit.Food;
import org.fasttrackit.Game;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Animal implements Runnable {

    private Game game;
    private ArrayList<String> food = new ArrayList<>();
    private EntertainmentActivity[] activities = new EntertainmentActivity[4];

    private long id;
    private String name;
    private String color;
    private double age;
    private String gender;
    private String favoriteFoodName;
    private String favoriteActivityName;
    private double time;
    private int gameplayed;

    private int hungerLevel;
    private int happinessLevel;

    public ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Animal(String name, String color, double age, String gender,
           String favoriteFoodName, String favoriteActivityName, int hungerLevel, int happinessLevel) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
        this.favoriteFoodName = favoriteFoodName;
        this.favoriteActivityName = favoriteActivityName;
        this.hungerLevel = hungerLevel;
        this.happinessLevel = happinessLevel;

        scheduler.scheduleAtFixedRate(this::run, 35, 25, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::run2, 35, 25, TimeUnit.SECONDS);
    }

    private void initFoodTimer() {
        food.add("Royal");
        food.add("Amiry");
        food.add("Friskies");
        food.add("Petkult");
        food.add("Enjoy");
        food.add("Green-Point");
        food.add("Herrmanns");
        food.add("Piccolo");
        food.add("Reddy");
    }

    private void initActivitiesTimer() {
        EntertainmentActivity activity1 = new EntertainmentActivity("jogging");
        EntertainmentActivity activity2 = new EntertainmentActivity("skipping with a rope");
        EntertainmentActivity activity3 = new EntertainmentActivity("dance");
        EntertainmentActivity activity4 = new EntertainmentActivity("playing football");
        activities[0] = activity1;
        activities[1] = activity2;
        activities[2] = activity3;
        activities[3] = activity4;

    }

    @Override
    public void run() {
        initFoodTimer();

        this.setFavoriteFoodName(food.get(new Random().nextInt(food.size() + 1)));
        Food newFood = new Food(this.favoriteFoodName);
        System.out.println(this.getName() + "'s favorite food is: " + this.getFavoriteFoodName());
    }

    private void run2() {
        initActivitiesTimer();

        int asd = new Random().nextInt(activities.length + 1);
        this.setFavoriteActivityName(activities[asd].getName());
        System.out.println(this.getName() + "'s favorite activity is: " + this.getFavoriteActivityName());
    }

//

    public String name() {
        return this.getClass().getSimpleName();
    }


    public void expressHappiness() {
        System.out.println("No express happiness here");
    }

//

    public ScheduledExecutorService getScheduler() {
        return scheduler;
    }

    public void setScheduler(ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<String> getFood() {
        return food;
    }

    public void setFood(ArrayList<String> food) {
        this.food = food;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public EntertainmentActivity[] getActivities() {
        return activities;
    }

    public void setActivities(EntertainmentActivity[] activities) {
        this.activities = activities;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getGameplayed() {
        return gameplayed;
    }

    public void setGameplayed(int gameplayed) {
        this.gameplayed = gameplayed;
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

