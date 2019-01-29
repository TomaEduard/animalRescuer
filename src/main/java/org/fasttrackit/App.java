package org.fasttrackit;

public class App {
    public static void main(String[] args) {

        Rescuer firstRescuer = new Rescuer("Gigel", 250);

        Animal animal1 = new Animal("Bobby", "Black", 3.1, "Male");

        Animal Cat1 = new Cat("Chaika", "White", 2, "Female");
        Cat1.setFavoriteFoodName("Purina");
        Cat1.setFavoriteActivityName("walked");
//        Cat1.setRace("Bengal");
//        Cat1.setWaist("Medium");
//        Cat1.setWeight(2.1);

        Animal Dog1 = new Dog("Puffy", "Brown", 1, "Male");


        Veterinarian firstVeterinarian = new Veterinarian("Bob");

//        Food food1 = new Food("Purina");
//        food1.setPrice(14.99);
//        food1.setAmount(5);
//        food1.setAvailability("In stock");
//        food1.setExpiryDate(LocalDateTime.now().plusYears(10));
/*
        Food food2 = new Food("Pedigree");
        food2.setPrice(9.99);
        food2.setAmount(5);
        food2.setAvailability("In stock");
        food2.setExpiryDate(LocalDateTime.now().plusYears(10));

        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
        EntertainmentActivity activity2 = new EntertainmentActivity("playing with ball");

        Treatment firstTreatment = new Treatment("Pills");
        firstTreatment.setCost(13.99);
        firstTreatment.setDuration(45);
*/

//        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
//        EntertainmentActivity activity2 = new EntertainmentActivity("playing with ball");

        Game game1 = new Game();
        game1.start();
//
//        firstRescuer.walking(Cat1, activity1);
//
//        animal1.expressHappiness();
//        Cat1.expressHappiness();
//        Dog1.expressHappiness();
//
        firstRescuer.feed(Cat1, game1.food(0));
        firstRescuer.feed(Cat1, game1.food(1));


        firstRescuer.entertain(Cat1, game1.activity(0));
        firstRescuer.entertain(Cat1, game1.activity(1));


    }


}
