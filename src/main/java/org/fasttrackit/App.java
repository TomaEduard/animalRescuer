package org.fasttrackit;

public class App {
    public static void main(String[] args) {


        Animal animal = new Animal("Bobby", "Black", 3.1, "Male");
        Animal firstAnimal = new Cat("Chaika", "White", 2, "Female");
//        firstAnimal.setRace("Bichon Maltese");
//        firstAnimal.setWaist("Medium");
//        firstAnimal.setWeight(2.1);

        Dog secondAnimal = new Dog("Puffy", "Brown", 1, "Male");

/*
        Adoptator firstAdoptator = new Adoptator("John", firstAnimal, 355);
        firstAdoptator.setMoneyavaible(135);

        Veterinarian firstVeterinarian = new Veterinarian("Bob");

        AnimalFood firstAnimalFood = new AnimalFood("Purina", 14.99);
        firstAnimalFood.setAmount(5);
        firstAnimalFood.setAvailability("In stock");
        firstAnimalFood.setExpiryDate(LocalDateTime.now().plusYears(10));

        RecreationActivity firstRecreation = new RecreationActivity("Walked", firstAdoptator, firstAnimal );

        Treatment firstTreatment = new Treatment("Pills");
        firstTreatment.setCost(13.99);
        firstTreatment.setDuration(45);

        firstAdoptator.Feed(firstAnimal,firstAnimalFood);
        firstRecreation.walking(firstAdoptator, firstAnimal);
*/

        animal.expressHappiness();
        firstAnimal.expressHappiness();
        secondAnimal.expressHappiness();


    }


}
