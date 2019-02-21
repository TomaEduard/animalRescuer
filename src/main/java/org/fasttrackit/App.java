package org.fasttrackit;

public class App {
    public static void main(String[] args) {

        Rescuer firstRescuer = new Rescuer("Gigel");

//        Animal animal1 = new Animal("Bobby", "Black", 3.1,
//                "Male", "Pedigree", "playing with ball");
//
////
//        Animal cat1 = new Cat("Chaika", "White", 2, "Female", "Purina",
//                "walked", "Bengal", "Medium", 2.1);
//
//        cat1.getFavoriteFoodName();
//
//        Animal Dog1 = new Dog("Puffy", "Brown", 1, "Male", "Pedigre",
//                "playing with ball", "Bishon", "Small", 1.2);



        Veterinarian firstVeterinarian = new Veterinarian("Bob");
//
//        Food purina = new Food("Purina");
//        purina.setPrice(14.99);
//        purina.setAmount(5);
//        purina.setAvailability("In stock");
//        purina.setExpiryDate(LocalDateTime.now().plusYears(10));
//
//
//        Food pedigree = new Food("Pedigree");
//        pedigree.setPrice(9.99);
//        pedigree.setAmount(5);
//        pedigree.setAvailability("In stock");
//        pedigree.setExpiryDate(LocalDateTime.now().plusYears(10));
/*
        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
        EntertainmentActivity activity2 = new EntertainmentActivity("playing with ball");

        Treatment firstTreatment = new Treatment("Pills");
        firstTreatment.setCost(13.99);
        firstTreatment.setDuration(45);
*/
//        EntertainmentActivity activity1 = new EntertainmentActivity("walked");
//        EntertainmentActivity activity2 = new EntertainmentActivity("playing with ball");

        Game game = new Game();



        game.start();

//
//        firstRescuer.walking(Cat1, activity1);
//
//        animal1.expressHappiness();
//        Cat1.expressHappiness();
//        Dog1.expressHappiness();




/*

        firstRescuer.entertain(Cat1, game.activity(0));
        firstRescuer.entertain(Cat1, game.activity(1));
*/




    }


}
