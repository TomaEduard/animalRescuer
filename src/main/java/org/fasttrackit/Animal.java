package org.fasttrackit;


/*
private String race;
private String waist;
private double weight;
private String gender;
*/


public class Animal {

    private String name;
    private String color;
    private double age;
    private String gender;


    public Animal(String name, String color, double age, String gender) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
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
}

