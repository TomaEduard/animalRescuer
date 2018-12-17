package org.fasttrackit;

import java.time.Month;

public class App
{
    public static void main( String[] args )
    {
//        Animal
        Animal firstAnimal = new Animal();
        firstAnimal.type = "Dog";
        firstAnimal.race = "Bichon Maltese";
        firstAnimal.name = "Puffy";
        firstAnimal.gender = "Male";
        firstAnimal.age = 2.6;
        firstAnimal.waist = "Medium";
        firstAnimal.weight = 2.6;
        firstAnimal.favoriteFood = "Royal Canin";
        firstAnimal.favoriteRecreation = "Walking";
        firstAnimal.health = 10;
        firstAnimal.hungry = 8;
        firstAnimal.mood = "Neutral";

//        Animal secondAnimal = new Animal("Dog", "Siberian Husky", "Rex", "0.7",
//                "Medium", 1.4, 10, 9, "Sleppy", "Pedigree",
//                "Walking");

        Animal secondAnimal = new Animal();
        secondAnimal.race = "Siberian Husky";
        secondAnimal.name = "Rex";
        secondAnimal.gender = "Male";
        secondAnimal.age = 0.7;
        secondAnimal.waist = "Medium";
        secondAnimal.weight = 1.4;
        secondAnimal.favoriteFood = "Pedigree";
        secondAnimal.favoriteRecreation = "Walking";
        secondAnimal.health = 10;
        secondAnimal.hungry = 9;
        secondAnimal.mood = "Sleepy";

//        Adoptator
        Adoptator firstAdoptator = new Adoptator();
        firstAdoptator.name = "Jimmy";
        firstAdoptator.age = 16;
        firstAdoptator.moneyavaible = 450;
        firstAdoptator.contact = "0740850576";

//        Animal Feed
        AnimalFeed firstAnimalFeed = new AnimalFeed();
        firstAnimalFeed.name = "RoyalCanin";
        firstAnimalFeed.price = 39;
        firstAnimalFeed.amount = 3;
        java.time.LocalDate.of( 2011 , Month.MAY , 21 );
        firstAnimalFeed.Availability = "Instock";

//        Favorite Recreation
        FavoriteRecreation firstFavoriteRecreation = new FavoriteRecreation();
        firstFavoriteRecreation.name = "walking";
        firstFavoriteRecreation.time = 0.30;

//        Veterinarian
        Veterinarian firstVeterinarian = new Veterinarian();
        firstVeterinarian.name = "geremmy";
        firstVeterinarian.location = "Str. Decebal nr. 24";
        firstVeterinarian.contact = "0756405311";
        firstVeterinarian.price = 78;

//        AnimalHygiene
        AnimalHygiene firstAnimalHygiene = new AnimalHygiene();
        firstAnimalHygiene.type = "Brush";
        firstAnimalHygiene.Availability = "In stock";
        firstAnimalHygiene.price = 3.99;

//        Game
        Game firstGame = new Game();
        firstGame.adoptator = "";
        firstGame.veterinarian = "";
        firstGame.dog = "";
        firstGame.objects = "";

    }

}
