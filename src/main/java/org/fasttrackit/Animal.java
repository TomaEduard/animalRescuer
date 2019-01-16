package org.fasttrackit;

public class Animal {


    public static boolean mood;
    private String name;
    private String color;
    private double age;
    private String gender;

//

    public Animal(String name, String color, double age, String gender) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
    }

//

    public String mood() {
        return "The mood of the animal";

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

