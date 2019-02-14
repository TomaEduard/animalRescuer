package org.fasttrackit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Animal animal;
    private Rescuer rescuer;
    private Food food;
    private EntertainmentActivity activity;

    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Food> avaibleFood = new ArrayList<>();
    private EntertainmentActivity[] avaibleActivities = new EntertainmentActivity[2];


    public void start() {

        initRescuer();

        initAnimal();
        nameAnimal();

//        welcome to menu
        initFood();
        requireFeeding();

        initActivities();
        requireEntertain();

    }


    private void initAnimal() {

        System.out.println("\n Enter a number of what kind of animal do you want to save: \n  Press:");
        System.out.println("1 - Cat \n" +
                "2 - Dog ");
        System.out.println("Choose your action: ");

        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 1:
                Animal cat1 = new Cat("Chaika", "White", 2, "Female", "Purina",
                        "walked", "Bengal", "Medium", 2.1);

                System.out.println("Cat selected. ");
                this.animal = cat1;
                break;
            case 2:
                Animal dog1 = new Dog("Puffy", "Brown", 1, "Male", "Pedigre",
                        "playing with ball", "Bishon", "Small", 1.2);
                this.animal = dog1;
                System.out.println("Dog selected. ");
                break;

            default:
                System.out.println("Enter a valid number.");
                break;
        }

    }

    private void nameAnimal() {
        System.out.println("The animal does not have a name, give it one ! ");
        String nameAnimal = scanner.nextLine();
        this.animal.setName(nameAnimal);
        System.out.println("The neme of your animal is: " + nameAnimal);
    }

    private void initRescuer() {
        try {
            System.out.println("Enter your name:");
            String RescuerName = scanner.nextLine();
            Rescuer rescuer = new Rescuer(RescuerName);
            this.rescuer = rescuer;
            System.out.println("Hello " + RescuerName + ", and welcome to Tamagotchi Game !");

        } catch (InputMismatchException exception) {
            System.out.println("Re-enter a valid name");
            initRescuer();
        }
    }

    private void requireFeeding() {

        System.out.println("Select what kind of food you want to feed the animal: ");
        displayFood();
        int number = scanner.nextInt();
        System.out.println("You select number: " + number);
        number -= 1;

        this.food = food;
        Food food = new Food(food(number).getName());

        rescuer.feed(animal, food);
    }

    private void requireEntertain() {
        System.out.println("Select what kind of food you want to feed the animal: ");
        displayActivities();
        int number = scanner.nextInt();
        System.out.println("You select number: " + number);
        number -= 1;

        this.activity = activity;
        EntertainmentActivity activity  = new EntertainmentActivity(activity(number).getName());

        rescuer.entertain(animal, activity);
    }

//    food
    private void initFood() {
        Food purina = new Food("Purina");
        Food pedigree = new Food("Pedigree");
        avaibleFood.add(purina);
        avaibleFood.add(pedigree);
    }

    private void displayFood() {
        System.out.println("You have " + avaibleFood.size() + " items in your food list: ");
        for (int i = 0; i < avaibleFood.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + avaibleFood.get(i).getName());
        }
    }

    //    activities
    private void initActivities() {

        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
        EntertainmentActivity activity2 = new EntertainmentActivity("playing with ball");

        avaibleActivities[0] = activity1;
        avaibleActivities[1] = activity2;

    }

    private void displayActivities() {
        System.out.println("You have " + avaibleActivities.length + " activity: ");
        for (int i = 0; i < avaibleActivities.length; i++) {
            if (avaibleActivities[i] != null) ;
            System.out.println("\t" + (i + 1) + ". " + avaibleActivities[i].getName());
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

    public void setAvaibleFood(ArrayList<Food> avaibleFood) {
        this.avaibleFood = avaibleFood;
    }

    public EntertainmentActivity[] getAvaibleActivities() {
        return avaibleActivities;
    }

    public void setAvaibleActivities(EntertainmentActivity[] avaibleActivities) {
        this.avaibleActivities = avaibleActivities;
    }

}
