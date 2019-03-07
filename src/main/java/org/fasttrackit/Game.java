package org.fasttrackit;

import org.fasttrackit.domain.Animal;
import org.fasttrackit.domain.Cat;
import org.fasttrackit.domain.Dog;
import org.fasttrackit.domain.TopWinner;
import org.fasttrackit.persistence.AnimalRepository;
import org.fasttrackit.service.AnimalService;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    TopWinner topWinner = new TopWinner();
    private AnimalService animalService = new AnimalService();
    private Animal animal;
    private Rescuer rescuer;
    private Food food;
    private EntertainmentActivity activity;
    AnimalRepository animalRepository;

//    private static Scanner scanner = new Scanner(System.in);
//    private ArrayList<String> foodTimmer = new ArrayList<>();

    private ArrayList<Food> avaibleFood = new ArrayList<>();


    private EntertainmentActivity[] avaibleActivities = new EntertainmentActivity[4];
//    private EntertainmentActivity entertainmentActivity;


    public void start() throws SQLException, IOException, ClassNotFoundException {

        initRescuer();

        long start = System.currentTimeMillis();

        initAnimal();
        nameAnimal();

        animalService.findAnimalOrCreateService(topWinner);

        animalService.setAnimal(animal);

        rescuer.setHungerLevel(animal.getHungerLevel());
        rescuer.setHappinessLevel(animal.getHappinessLevel());

        topWinner.setHungerLevel(animal.getHungerLevel());
        topWinner.setHappinessLevel(animal.getHappinessLevel());

        System.out.println("--------topWinner.---------");
        System.out.println(topWinner.getHungerLevel());
        System.out.println(topWinner.getHappinessLevel());
        System.out.println("--------animal.---------");
        System.out.println(animal.getHungerLevel());
        System.out.println(animal.getHappinessLevel());
        System.out.println("--------hunger happiness---------");
        System.out.println(rescuer.getHungerLevel());
        System.out.println(rescuer.getHappinessLevel());

        printInstructions();


        initFood();
        initActivities();

        if (animal.getHungerLevel() > 0 && animal.getHappinessLevel() != 10) {
            boolean quit = false;
            String choice = "0";

            while (!quit) {
                System.out.println("Enter your choice: ");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextLine();
//                scanner.nextLine();

                if (animal.getHungerLevel() == 0 && animal.getHappinessLevel() == 10) {
                    quit = true;
                }
                switch (choice) {
                    case "0":
                        printInstructions();
                        break;
                    case "1":
                        displayFood();
                        break;
                    case "2":
                        addFoodItem();
                        break;
                    case "3":
                        requireFeeding();
                        break;
                    case "4":
                        displayActivitiesWithPrintInstcutruins();
                        break;
                    case "5":
                        addActivityItem();
                        break;
                    case "6":
                        requireEntertain();
                        break;
                    case "7":
                        displayFavoriteFoodAndActivitiy();
                        break;
                    case "8":
                        animalService.getTopWinners();
                        break;
                    case "10":
                        quit = true;
                        break;
                    default:
                        System.out.println("ENTER A VALID NUMBER !");
                        printInstructions();
                }
            }
        }

//    Conditia de sfarsit
        if (animal.getHungerLevel() == 0 && animal.getHappinessLevel() == 10) {
//    Se opreste scheduler'ul de modificare a preferintei
            animal.scheduler.shutdown();
//    Se opreste timerul si se transforma intr-o valoare corecta
            long end = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00");
            double time = Double.parseDouble(formatter.format((end - start) / 1000.0));

            System.out.println("\n\u2690\u2690\u2690 Congrats " + rescuer.getName() + "!" + " \u2690\u2690\u2690" +
                    " You had finished the game !\n" +
                    animal.getName() + "'s, feels good and is happy now! " +
                    "\nYou finish this game in " + time + " seconds.");

//            topWinner.setFavoriteFoodName(animal.getFavoriteFoodName());
//            topWinner.setFavoriteActivityName(animal.getFavoriteActivityName());

            topWinner.setHungerLevel(animal.getHungerLevel());
            topWinner.setHappinessLevel(animal.getHappinessLevel());
            topWinner.setTime(time);
            topWinner.setGameplayed(1);

            animalService.updateGameHungerAndHappinessService(topWinner);

        }
    }

    private void printInstructions() {
        System.out.println("\n Able actions: \n Press: ");
        System.out.println("0 - To print Menu options. \n" +
                "1 - To print the food list. \n" +
                "2 - To add the food to the list. \n" +
                "3 - To feed the animal.\n" +
                "4 - To print the activities list. \n" +
                "5 - To add the activity to the list. \n" +
                "6 - To do an activity with animal. \n" +
                "7 - To show actually animal favourite food and activity. \n" +
                "8 - To show TopWinners. \n" +
                "10 - To close the applicaion." +
                "\n \n The hanger-level of " + animal.getName() + "'s is: " +
                animal.getHungerLevel() + "/10  \uD83C\uDF57" +
                "\n The happiness-level of " + animal.getName() + "'s is: " +
                animal.getHappinessLevel() + "/10  \uD83D\uDE0A");
    }

    public int getHungerLevel() {
        return animal.getHungerLevel();
    }

    public int getHappinessLevel() {
        return animal.getHappinessLevel();
    }

    private void initRescuer() {
        try {
            System.out.println("Enter your name:");
            Scanner scanner = new Scanner(System.in);
            String RescuerName = scanner.nextLine();
            this.rescuer = new Rescuer(RescuerName);
            System.out.println("Hello " + RescuerName + ", And Welcome To <<< Tamagotchi Game! >>>");

        } catch (InputMismatchException exception) {
            System.out.println("Re-enter a valid name");
            initRescuer();
        }
    }

//    Scanner scanner = new Scanner(System.in);

    private int initAnimal() {

        System.out.println("\n Enter a number of what kind of animal do you want to save: \n  Press:");
        System.out.println("1 - Cat \n" +
                "2 - Dog ");
        System.out.println("Choose your action: ");

        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();

        try {
            switch (action) {
                case 1:
                    this.animal = new Cat("unknown",
                            randomColor(),
                            // random age
                            ThreadLocalRandom.current().nextInt(1, 8),
                            randomGender(),
                            randomFood(),
                            randomEntertainmentActivity(),
                            3, 3,
                            randomCatRace(),
                            randomWaist(),
                            randomWeight());

                    topWinner.setName(animal.getName());
                    topWinner.setColor(animal.getColor());
                    topWinner.setAge(animal.getAge());
                    topWinner.setGender(animal.getGender());
                    topWinner.setFavoriteFoodName(animal.getFavoriteFoodName());
                    topWinner.setFavoriteActivityName(animal.getFavoriteActivityName());
                    topWinner.setHungerLevel(animal.getHungerLevel());
                    topWinner.setHappinessLevel(animal.getHappinessLevel());


                    break;

                case 2:
                    this.animal = new Dog("unknown",
                            randomColor(),
                            // random age
                            ThreadLocalRandom.current().nextInt(1, 8),
                            randomGender(),
                            randomFood(),
                            randomEntertainmentActivity(),
                            10, 0,
                            randomDogRace(),
                            randomWaist(),
                            randomWeight());

                    topWinner.setName(animal.getName());
                    topWinner.setColor(animal.getColor());
                    topWinner.setAge(animal.getAge());
                    topWinner.setGender(animal.getGender());
                    topWinner.setFavoriteFoodName(animal.getFavoriteFoodName());
                    topWinner.setFavoriteActivityName(animal.getFavoriteActivityName());
                    topWinner.setHungerLevel(animal.getHungerLevel());
                    topWinner.setHappinessLevel(animal.getHappinessLevel());


                    break;
                default:
                    System.out.println("Please enter a valid number!");
                    initAnimal();
                    break;
            }
        } catch (NullPointerException ex) {
            System.out.println("ENTER A VALID NUMBER !");
            return initAnimal();
        }


        return action;
    }

    private String randomWaist() {
        ArrayList<String> waist = new ArrayList<>();
        waist.add("Small");
        waist.add("Medium");
        waist.add("Large");
        int r = ThreadLocalRandom.current().nextInt(waist.size());
        return waist.get(r);
    }

    private double randomWeight() {
        NumberFormat formatNumber = new DecimalFormat("#0.00");
        return Double.parseDouble(formatNumber.format(ThreadLocalRandom.current().nextDouble(1, 6)));
    }

    private String randomColor() {
        ArrayList<String> color = new ArrayList<>();
        color.add("Brown");
        color.add("Dark Brown");
        color.add("Light Brown");
        color.add("Black");
        color.add("Gray");
        color.add("White");
        int r = ThreadLocalRandom.current().nextInt(color.size());
        return color.get(r);
    }

    private String randomCatRace() {
        ArrayList<String> dogRace = new ArrayList<>();
        dogRace.add("Balinese");
        dogRace.add("Chartreux");
        dogRace.add("Korat");
        dogRace.add("Devon Rex");
        dogRace.add("Tonkinese");
        dogRace.add("Siberian");
        dogRace.add("Norwegian Forest");
        dogRace.add("Persian");
        dogRace.add("Pixie-Bob");
        int r = ThreadLocalRandom.current().nextInt(dogRace.size());
        return dogRace.get(r);
    }

    private String randomGender() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        int r = ThreadLocalRandom.current().nextInt(gender.size());
        return gender.get(r);
    }

    private String randomDogRace() {
        ArrayList<String> catRace = new ArrayList<>();
        catRace.add("Welsh Terrier");
        catRace.add("Swedish Vallhund");
        catRace.add("Pug");
        catRace.add("Doberman Pinscher");
        catRace.add("Norfolk Terrier");
        catRace.add("Mastiff");
        catRace.add("Lhasa Apso");
        catRace.add("English Foxhound");
        catRace.add("Havanese");
        catRace.add("Japanese Spitz");
        catRace.add("Goldador");
        int r = ThreadLocalRandom.current().nextInt(catRace.size());
        return catRace.get(r);
    }

    private void nameAnimal() {
        System.out.println("The animal does not have a name, give it one ! ");
        Scanner scanner = new Scanner(System.in);
        String nameAnimal = scanner.nextLine();
        this.animal.setName(nameAnimal);
        System.out.println("The neme of your animal is: " + nameAnimal);
        System.out.println("\n" +
                "The aim of the game is to keep the animal in the best conditions. That's why \n" +
                " you need to be careful about his preferences and needs.\n" +
                "\n" +
                "To succeed in meeting animal needs, you need to reduce hunger \ud83c\udf57 and increase \n" +
                "heppines level \uD83D\uDE0A to complete the game and adopt another animal.\n" +
                "\n" +
                "*" + animal.getName() + "'s favorite food is " + animal.getFavoriteFoodName() +
                " and sports is playing with ball.\n " +
                "You can help with these tips to play the game in a timely manner. Have fun!");

        topWinner.setName(nameAnimal);

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

    public String randomFood() {
        ArrayList<String> listFood = new ArrayList<>();
        listFood.add("Piccolo");
        listFood.add("Pedigree");
        listFood.add("Amity");
        listFood.add("Friskies");
        listFood.add("Unipro");
        listFood.add("Wellness");

        int r = ThreadLocalRandom.current().nextInt(listFood.size() - 1);
        return listFood.get(r);
    }

    private void displayFood() {
        System.out.println("You have " + avaibleFood.size() + " items in your food list: ");
        for (int i = 0; i < avaibleFood.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + avaibleFood.get(i).getName());
        }

        System.out.println("Press any key for Menu.");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        if (number.equals("0")) {
            animal.setHungerLevel(0);
            animal.setHappinessLevel(10);
            printInstructions();
        } else {
            printInstructions();
        }
    }

    private String addFoodItem() {
        System.out.println("You have: " + avaibleFood.size() + " items in your food list: ");
        for (int i = 0; i < avaibleFood.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + avaibleFood.get(i).getName());
        }
        System.out.println("Enter the new food name: ");
        Scanner scanner = new Scanner(System.in);
        String nameFood = scanner.nextLine();
        try {
            Food newFood = new Food(nameFood);
            avaibleFood.add(newFood);
            int number = avaibleFood.indexOf(newFood);
            number += 1;
            System.out.println(newFood.getName() + " has been successfully added on the list on position " +
                    "# " + number);
            displayFood();
        } catch (IndexOutOfBoundsException | InputMismatchException |
                StackOverflowError | NullPointerException exception) {
            System.out.println("Please enter a valid number!");
            return addFoodItem();
        }
        return nameFood;
    }

    public Food food(int index) {
        return avaibleFood.get(index);
    }

    private int requireFeeding() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("You have # " + avaibleFood.size() + " items in your food list: ");
        for (int i = 0; i < avaibleFood.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + avaibleFood.get(i).getName());
        }
        System.out.println("Select what kind of food you want to feed the animal: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            if (number == 0) {
                printInstructions();
                return number;
            } else {
                System.out.println("You select number: " + number);
                number -= 1;
                Food food = new Food(food(number).getName());
                rescuer.feed(animal, food);

                // update animal & topWinner values
                animal.setHungerLevel(rescuer.getHungerLevel());
                animal.setHappinessLevel(rescuer.getHappinessLevel());
                topWinner.setHungerLevel(animal.getHungerLevel());
                topWinner.setHappinessLevel(animal.getHappinessLevel());

                // query to db
                animalService.updateAnimalHungerlevel(topWinner);
                animalService.updateAnimalHappineslevel(topWinner);

                return number;
            }
        } catch (IndexOutOfBoundsException | InputMismatchException | StackOverflowError exception) {
            System.out.println("Please enter a valid number!");
            return requireFeeding();
        }
    }


    //    Activities
    private void initActivities() {
        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
        EntertainmentActivity activity2 = new EntertainmentActivity("swimming");
        EntertainmentActivity activity3 = new EntertainmentActivity("dance");
        EntertainmentActivity activity4 = new EntertainmentActivity("football");
        avaibleActivities[0] = activity1;
        avaibleActivities[1] = activity2;
        avaibleActivities[2] = activity3;
        avaibleActivities[3] = activity4;
    }

    public String randomEntertainmentActivity() {
        ArrayList<String> listActivity = new ArrayList<>();
        listActivity.add("walked");
        listActivity.add("swimming");
        listActivity.add("dance");
        listActivity.add("football");
        listActivity.add("jumping");

        int r = ThreadLocalRandom.current().nextInt(listActivity.size() - 1);
        return listActivity.get(r);
    }

    public void displayActivity() {
        System.out.println("You have: " + avaibleActivities.length + " activity: ");
        for (int i = 0; i < avaibleActivities.length; i++) {
            if (avaibleActivities[i] != null) ;
            System.out.println("\t" + (i + 1) + ". " + avaibleActivities[i].getName());
        }
    }

    private void displayActivitiesWithPrintInstcutruins() {
        displayActivity();
        System.out.println("Press any key for Menu");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        if (number != null) {
            printInstructions();
        }
    }

//            for (int hungerLevel = 0; hungerLevel < avaibleActivities.length; hungerLevel++)

//            if (avaibleActivities[hungerLevel] == null) {

    public void addActivityItem() {
        displayActivity();
        System.out.println("Enter the activity name: ");

        EntertainmentActivity[] newAvaibleActivities = Arrays.copyOf(avaibleActivities,
                avaibleActivities.length + 1);

        Scanner scanner = new Scanner(System.in);
        String nameActivities = scanner.nextLine();
        EntertainmentActivity newActivities = new EntertainmentActivity(nameActivities);

        newAvaibleActivities[newAvaibleActivities.length - 1] = newActivities;

        this.avaibleActivities = newAvaibleActivities;
//        System.out.println("You have: " + avaibleActivities.length + " activity: ");
        displayActivity();
    }

    public EntertainmentActivity activity(int indexNumber) {
        return avaibleActivities[indexNumber];
    }

    private int requireEntertain() throws SQLException, IOException, ClassNotFoundException {
        displayActivity();
        System.out.println("Select what kind of activity you want to practice with the animal: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        number -= 1;
        try {
            EntertainmentActivity activity = new EntertainmentActivity(activity(number).getName());
            rescuer.entertain(animal, activity);

            topWinner.setHappinessLevel(animal.getHappinessLevel());
            // querry update happineslevel
            animalService.updateAnimalHappineslevel(topWinner);

        } catch (IndexOutOfBoundsException | InputMismatchException |
                StackOverflowError | NullPointerException exception) {
            System.out.println("Please enter a valid number!");
            return requireEntertain();
        }
        return number;
    }

    public void displayFavoriteFoodAndActivitiy() {
        System.out.println(animal.getName() + "'s favorite food is: " +
                animal.getFavoriteFoodName() + "\nand favorite activity is: " +
                animal.getFavoriteActivityName());
        System.out.println("\nPress 0 - for back to Menu.");
    }

    //Scanner scanner = new Scanner(System.in);
//    int number = scanner.nextInt();
//            if (number == 0) {
//        printInstructions();
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

}
