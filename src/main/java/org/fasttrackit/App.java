package org.fasttrackit;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {

        Cat firstAnimal = new Cat("Chaika", "White", 2, "Female");
        firstAnimal.setName("Chaika");
        firstAnimal.setRace("Bichon Maltese");
        firstAnimal.setWaist("Medium");
        firstAnimal.setWeight(2.1);

        Adoptator firstAdoptator = new Adoptator("John", firstAnimal);
        firstAdoptator.setMoneyavaible(135);

        Veterinarian firstVeterinarian = new Veterinarian("Bob");

        AnimalFood firstAnimalFood = new AnimalFood("Purina", 14.99);
        firstAnimalFood.setAmount(5);
        firstAnimalFood.setAvailability("In stock");
        firstAnimalFood.setExpiryDate(LocalDateTime.now().plusYears(10));

        RecreationActivity firstRecreation = new RecreationActivity("Walked");

        Treatment firstTreatment = new Treatment("Pills");
        firstTreatment.setCost(13.99);
        firstTreatment.setDuration(45);



        firstAdoptator.Feed(firstAnimal,firstAnimalFood);
        firstRecreation.walking(firstAdoptator, firstAnimal);



    }


}
