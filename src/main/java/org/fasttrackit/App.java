package org.fasttrackit;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {

        Rescuer firstRescuer = new Rescuer("Gigel", 250);

        Animal animal = new Animal("Bobby", "Black", 3.1, "Male");
        Animal firstAnimal = new Cat("Chaika", "White", 2, "Female");
        firstAnimal.setFavoriteFoodName("Purina");
        firstAnimal.setFavoriteActivityName("walked");
//        firstAnimal.setRace("Bichon Maltese");
//        firstAnimal.setWaist("Medium");
//        firstAnimal.setWeight(2.1);

        Dog secondAnimal = new Dog("Puffy", "Brown", 1, "Male");


        Veterinarian firstVeterinarian = new Veterinarian("Bob");

        AnimalFood firstAnimalFood = new AnimalFood("Purina", 14.99);
        firstAnimalFood.setAmount(5);
        firstAnimalFood.setAvailability("In stock");
        firstAnimalFood.setExpiryDate(LocalDateTime.now().plusYears(10));

        AnimalFood SecondAnimalFood = new AnimalFood("Pedigree", 14.99);
        firstAnimalFood.setAmount(5);
        firstAnimalFood.setAvailability("In stock");
        firstAnimalFood.setExpiryDate(LocalDateTime.now().plusYears(10));

        RecreationActivity firstRecreation = new RecreationActivity("walked");
        RecreationActivity secondRecreation = new RecreationActivity("ball game");

        Treatment firstTreatment = new Treatment("Pills");
        firstTreatment.setCost(13.99);
        firstTreatment.setDuration(45);
/*
        firstAdoptator.Feed(firstAnimal,firstAnimalFood);
        firstRecreation.walking(firstAdoptator, firstAnimal);
*/

//        animal.expressHappiness();
//        firstAnimal.expressHappiness();
//        secondAnimal.expressHappiness();

//        firstRescuer.feed(firstAnimal, firstAnimalFood);
        firstRescuer.entertain(firstAnimal, firstRecreation);
//        firstRescuer.entertain("Chaika", secondRecreation);

    }


}
