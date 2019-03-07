package org.fasttrackit.domain;

public class TopWinner {


//    O clasa echivalenta cu tabela creata
//    Are aceleasi proprietati ca, clasa Animal

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

//    private Animal animal;
//    private String animalName;
//


    public TopWinner() {
    }

    public TopWinner(int hungerLevel, int happinessLevel) {
        this.hungerLevel = hungerLevel;
        this.happinessLevel = happinessLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
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

    public int getGameplayed() {
        return gameplayed;
    }

    public void setGameplayed(int gameplayed) {
        this.gameplayed = gameplayed;
    }


    @Override
    public String toString() {
        return "TopWinner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", favoriteFoodName='" + favoriteFoodName + '\'' +
                ", favoriteActivityName='" + favoriteActivityName + '\'' +
                ", time=" + time +
                ", gameplayed=" + gameplayed +
                ", hungerLevel=" + hungerLevel +
                ", happinessLevel=" + happinessLevel +
                '}';
    }
}
