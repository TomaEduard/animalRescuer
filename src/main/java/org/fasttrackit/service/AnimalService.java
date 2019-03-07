package org.fasttrackit.service;

import org.fasttrackit.Game;
import org.fasttrackit.domain.Animal;
import org.fasttrackit.domain.TopWinner;
import org.fasttrackit.persistence.AnimalRepository;
import org.fasttrackit.transfer.TopWinnerListResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AnimalService {

    private AnimalRepository animalRepository = new AnimalRepository();
    TopWinner topWinner;
    Game game;

//    The method animalRepository.createAnimal(topWinner); called inside animalRepository.AnimalRepository
//    public void createAnimalService(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
//        System.out.println("*Create animal: " + topWinner);
//        animalRepository.createAnimal(topWinner);
//    }

//    After the user write the name of the animal we do only 1 insert in db(not 1 for unknown name and 1 for update this)
//    public void updateAnimalNameService(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
//        System.out.println("*SET animal name entry: " + topWinner.getName());
//        animalRepository.updateAnimalName(topWinner);
//    }

    public void findAnimalOrCreateService(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("*findAnimalOrCreateService: ");
        animalRepository.findAnimalOrCreateService(topWinner);
    }

    public void updateGameHungerAndHappinessService(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("*Update gameplayed: \n ");
        animalRepository.updateGameHungerAndHappiness(topWinner);
    }

    public void updateAnimalHungerlevel(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
//        topWinner.setHungerLevel(game.getHungerLevel());
//        System.out.println("*Hungerlevel entry: " + topWinner.getHungerLevel());
        animalRepository.updateAnimalHunterlevel(topWinner);
    }

    public void updateAnimalHappineslevel(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
//        topWinner.setHappinessLevel(game.getHappinessLevel());
//        System.out.println("*Happinesslevel entry: " + topWinner.getHappinessLevel());
        animalRepository.updateAnimalHappinesslevel(topWinner);
    }

    public TopWinnerListResponse getTopWinners() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("*Retriving top winners.");
        List<TopWinner> topWinners = animalRepository.showAllAnimalsService();
        return new TopWinnerListResponse(topWinners);
    }

    public TopWinner setAnimal(Animal animal) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("*set Animal");
//        animalRepository.findAnimalOrCreateService(animalRepository.test());

        animal.setHappinessLevel(animalRepository.getHappiness());
        animal.setHungerLevel(animalRepository.getHunger());

        return new TopWinner(3, 3);
    }

}
