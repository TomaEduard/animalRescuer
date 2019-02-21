package org.fasttrackit;

import java.util.*;

public class Game {

    private Animal animal;
    private Rescuer rescuer;
    private Food food;
    private EntertainmentActivity activity;

    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Food> avaibleFood = new ArrayList<>();
    private EntertainmentActivity[] avaibleActivities = new EntertainmentActivity[3];
    private EntertainmentActivity entertainmentActivity;


    public void start() {

        initRescuer();
        initAnimal();
        nameAnimal();

        boolean quit = false;
        int choice = 0;

        printInstructions();

        initFood();
        initActivities();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    displayFood();
                    break;
                case 2:
                    addFoodItem();
                    break;
                case 3:
                    displayFood();
                    requireFeeding();
                    break;
                case 4:
                    displayActivities();
                    break;
                case 5:
                    displayActivities();
                    addActivityItem();
                    break;
                case 6:
                    requireEntertain();
                case 7:
                    displayFavoriteFoodAndActivitiy();
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\n Able actions: \n Press:");
        System.out.println("0 - To print Menu options. \n" +
                "1 - To print the food list. \n" +
                "2 - To add the food to the list. \n" +
                "3 - To feed the animal.\n" +
                "4 - To print the activities list. \n" +
                "5 - To add the activity to the list. \n" +
                "6 - To do an activity with animal. \n" +
                "7 - To show actually animal favourite food and activity. \n" +
                "9 - To close the applicaion.");
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
                Animal cat1 = new Cat("unknown", "White", 2, "Female", "Purina",
                        "playing with ball", "Bengal", "Medium", 2.1);
                this.animal = cat1;
                break;
            case 2:
                Animal dog1 = new Dog("unknown", "Brown", 1, "Male", "Purina",
                        "playing with ball", "Bishon", "Small", 1.2);
                this.animal = dog1;
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
        System.out.println("\n" +
                "The aim of the game is to keep the animal in the best conditions. That's why \n" +
                " you need to be careful about his preferences and needs.\n" +
                "\n" +
                "To succeed in meeting animal needs, you need to reduce hunger and increase \n" +
                "heppines level to complete the game and adopt another animal.\n" +
                "\n" +
                "*" + animal.getName() + "'s favorite food is " + animal.getFavoriteFoodName() +
                " and sports is playing with ball.\n " +
                "You can help with these tips to play the game in a timely manner. Have fun!");
    }

    private void initRescuer() {
        try {
            System.out.println("Enter your name:");
            String RescuerName = scanner.nextLine();
            Rescuer rescuer = new Rescuer(RescuerName);
            this.rescuer = rescuer;
            System.out.println("Hello " + RescuerName + ", and welcome to <<<Tamagotchi Game!>>>");

        } catch (InputMismatchException exception) {
            System.out.println("Re-enter a valid name");
            initRescuer();
        }
    }

    private void requireFeeding() {

        System.out.println("Select what kind of food you want to feed the animal: ");
        System.out.println("Press 0 - for back to Menu.");
        int number = scanner.nextInt();
        if (number == 0) {
            printInstructions();
        } else {
            System.out.println("You select number: " + number);
            number -= 1;

            this.food = food;
            Food food = new Food(food(number).getName());

            rescuer.feed(animal, food);
        }
    }

    //    Food
    private void initFood() {
        Food piccolo = new Food("Piccolo");
        Food pedigree = new Food("Pedigree");
        Food amiry = new Food("Amity");
        Food friskies = new Food("Friskies");
        Food unipro = new Food("Unipro");
        Food wellness = new Food("Wellness");
        avaibleFood.add(piccolo);
        avaibleFood.add(pedigree);
        avaibleFood.add(amiry);
        avaibleFood.add(friskies);
        avaibleFood.add(unipro);
        avaibleFood.add(wellness);
    }

    private void displayFood() {
        System.out.println("You have " + avaibleFood.size() + " items in your food list: ");
        for (int i = 0; i < avaibleFood.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + avaibleFood.get(i).getName());
        }
//        System.out.println("Press 0 - for back to Menu.");
//        int number = scanner.nextInt();
//        if (number == 0) {
//            printInstructions();
//        }
    }

    public void addFoodItem() {
        System.out.println("Enter the food name: ");
        String nameFood = scanner.nextLine();
        Food newFood = new Food(nameFood);
        avaibleFood.add(newFood);
        System.out.println(newFood.getName() + " has been successfully added on the list on position " +
                "# " + avaibleFood.indexOf(newFood));
        displayFood();
    }

/*
    public void modifyFoodItem () {
        displayFood();
        System.out.println("Current item number you wanna to modify: ");
        int number = scanner.nextInt();
        number -= 1;

        System.out.println("Enter the name of replacement item: ");
        String newItem = scanner.nextLine();
        scanner.nextLine();
        Food food1 = new Food(newItem);

        System.out.println(newItem);
        modifyFoodItem(number, food);
        displayFood();

        System.out.println("Press 0 - for back to Menu.");
        if (number == 0) {
            printInstructions();
        }
    }

    private void modifyFoodItem (int position, Food newItem) {
        avaibleFood.set(position, newItem);
        System.out.println("Food item " + (position + 1) + "has been modified." );
    }
*/

    private void requireEntertain() {
        System.out.println("Select what kind of food you want to feed the animal: ");
        displayActivities();
        int number = scanner.nextInt();
        System.out.println("You select number: " + number);
        number -= 1;

        this.activity = activity;
        EntertainmentActivity activity = new EntertainmentActivity(activity(number).getName());

        rescuer.entertain(animal, activity);
    }


    //    activities
    private void initActivities() {
        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
        EntertainmentActivity activity2 = new EntertainmentActivity("swiming");
        EntertainmentActivity activity3 = new EntertainmentActivity("dance");
        avaibleActivities[0] = activity1;
        avaibleActivities[1] = activity2;
        avaibleActivities[2] = activity3;
    }

    private void displayActivities() {
        System.out.println("You have " + avaibleActivities.length + " activity: ");
        for (int i = 0; i < avaibleActivities.length; i++) {
            if (avaibleActivities[i] != null) ;
            System.out.println("\t" + (i + 1) + ". " + avaibleActivities[i].getName());
        }
    }

    //        for (int i = 0; i < avaibleActivities.length; i++)
//            if (avaibleActivities[i] == null) {
    public void addActivityItem() {
        System.out.println("Enter the activity name: ");

        EntertainmentActivity[] newAvaibleActivities = Arrays.copyOf(avaibleActivities,
                avaibleActivities.length + 1);
//                        new EntertainmentActivity[2];

        String nameActivities = scanner.nextLine();
        EntertainmentActivity newActivities = new EntertainmentActivity(nameActivities);

        newAvaibleActivities[newAvaibleActivities.length - 1] = newActivities;

        this.avaibleActivities = newAvaibleActivities;

//            }
    }

    public void displayFavoriteFoodAndActivitiy() {
        System.out.println(animal.getName() + "'s favorite food is: " +
                animal.getFavoriteFoodName() + "\nand favorite activity is: " +
                animal.getFavoriteActivityName());
        System.out.println("\nPress 0 - for back to Menu.");
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Rescuer getRescuer() {
        return rescuer;
    }

    public void setRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public EntertainmentActivity getActivity() {
        return activity;
    }

    public void setActivity(EntertainmentActivity activity) {
        this.activity = activity;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Game.scanner = scanner;
    }
}
