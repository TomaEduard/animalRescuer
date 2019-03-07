package org.fasttrackit.persistence;


import org.fasttrackit.Game;
import org.fasttrackit.Rescuer;
import org.fasttrackit.domain.TopWinner;
import org.fasttrackit.service.AnimalService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {
    private TopWinner topWinner;
    private Rescuer rescuer;
    private Game game;

    // Show All Animals
    public List<TopWinner> showAllAnimalsService() throws SQLException, IOException, ClassNotFoundException {

        // 1. Get a connection to database
        Connection connection = DatabaseConfiguration.getConnection();

        // 2. Create a statement
        Statement statement = connection.createStatement();
        // 3. Execute a SQL query
        ResultSet resultSet = statement.executeQuery("select * from animals;");
        // 4. Process the result set

        List<TopWinner> response = new ArrayList<>();

        while (resultSet.next()) {
            TopWinner topWinner = new TopWinner();
            topWinner.setId(resultSet.getLong(1));
            topWinner.setName(resultSet.getString(2));
            topWinner.setColor(resultSet.getString(3));
            topWinner.setAge(resultSet.getDouble(4));
            topWinner.setGender(resultSet.getString(5));
            topWinner.setFavoriteFoodName(resultSet.getString(6));
            topWinner.setFavoriteActivityName(resultSet.getString(7));
            topWinner.setTime(resultSet.getDouble(8));
            topWinner.setHungerLevel(resultSet.getInt(9));
            topWinner.setHappinessLevel(resultSet.getInt(10));
            topWinner.setGameplayed(resultSet.getInt(11));
            response.add(topWinner);
            System.out.println(topWinner);

        }
        return response;

    }

//    public List<TopWinner> getTopWinners() throws SQLException, IOException, ClassNotFoundException {
//        Connection connection = DatabaseConfiguration.getConnection();
//
//        String query = "SELECT `name`, gameplayed FROM animals ORDER BY gameplayed DESC;";
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(query);
//
//        List<TopWinner> response = new ArrayList<>();
//
//        while (resultSet.next()) {
//            TopWinner topWinner = new TopWinner();
//            topWinner.setId(resultSet.getLong("id"));
//            topWinner.setName(resultSet.getString("name"));
//            topWinner.setGameplayed(resultSet.getInt("gameplayed"));
//            response.add(topWinner);
//        }
//        return response;
//    }

    //    CREATE ANIMAL
    public void createAnimal(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = DatabaseConfiguration.getConnection();

        String insertSql = "INSERT INTO animals (`name`, color, age, gender, favoriteFoodName,"
                + " favoriteActivityName, time, hungerLevel, happinessLevel, gameplayed)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, topWinner.getName());
        preparedStatement.setString(2, topWinner.getColor());
        preparedStatement.setDouble(3, topWinner.getAge());
        preparedStatement.setString(4, topWinner.getGender());
        preparedStatement.setString(5, topWinner.getFavoriteFoodName());
        preparedStatement.setString(6, topWinner.getFavoriteActivityName());
        preparedStatement.setDouble(7, topWinner.getTime());
        preparedStatement.setInt(8, topWinner.getHungerLevel());
        preparedStatement.setInt(9, topWinner.getHappinessLevel());
        preparedStatement.setInt(10, topWinner.getGameplayed());

        preparedStatement.executeUpdate();

    }

    public TopWinner findAnimalOrCreateService(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
        // 1. Get a connection to database
        Connection connection = DatabaseConfiguration.getConnection();

        // 3. Execute a SQL query
        String query = "SELECT * FROM animals;";

        // 2. Create a statement
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        boolean isSame = false;

        // 4. Process the result set
        while (resultSet.next()) {

            TopWinner topWinner1 = new TopWinner();
            topWinner1.setName(resultSet.getString(2));

            if (topWinner.getName().equals(topWinner1.getName())) {
                isSame = true;
                topWinner1.setId(resultSet.getLong("id"));
                topWinner1.setColor(resultSet.getString(3));
                topWinner1.setAge(resultSet.getDouble(4));
                topWinner1.setGender(resultSet.getString(5));
                topWinner1.setFavoriteFoodName(resultSet.getString(6));
                topWinner1.setFavoriteActivityName(resultSet.getString(7));
                topWinner1.setTime(resultSet.getDouble(8));
                topWinner1.setHungerLevel(resultSet.getInt(9));
                topWinner1.setHappinessLevel(resultSet.getInt(10));
                topWinner1.setGameplayed(resultSet.getInt(11));

                topWinner = topWinner1;
                this.topWinner = topWinner1;
                this.topWinner.setHappinessLevel(topWinner1.getHappinessLevel());
                this.topWinner.setHungerLevel(topWinner1.getHungerLevel());
                break;
            }

        }

        if (!isSame) {
            createAnimal(topWinner);
            System.out.println("^Create a new animal in Database");
        }

        System.out.println("hunterLevel= " + topWinner.getHungerLevel() +
                "   happinessLevel= " + topWinner.getHappinessLevel());

        this.topWinner = topWinner;
        return topWinner;
    }

    public int getHappiness() {
        return this.topWinner.getHappinessLevel();
    }

    public int getHunger() {
        return this.topWinner.getHungerLevel();
    }

    //    Gameplayed
    public void updateGameHungerAndHappiness(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DatabaseConfiguration.getConnection();

        String insertSql = "UPDATE animals SET " +
                "gameplayed = gameplayed + 1, " +
                "time = ?, " +
                "hungerLevel = ?, " +
                "happinessLevel = ? " +
                "WHERE name = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setDouble(1, topWinner.getTime());
        preparedStatement.setInt(2, topWinner.getHungerLevel());
        preparedStatement.setInt(3, topWinner.getHappinessLevel());
        preparedStatement.setString(4, topWinner.getName());

        preparedStatement.executeUpdate();

    }

    //    hungerLevel
    public void updateAnimalHunterlevel(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = DatabaseConfiguration.getConnection();

        String insertSql = "UPDATE animals SET " +
                "hungerLevel = ? " +
                "WHERE name = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setInt(1, topWinner.getHungerLevel());
        preparedStatement.setString(2, topWinner.getName());

        preparedStatement.executeUpdate();

    }

    //    happineslevel
    public void updateAnimalHappinesslevel(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {

        Connection connection = DatabaseConfiguration.getConnection();

        String insertSql = "UPDATE animals SET " +
                "happinessLevel = ? " +
                "WHERE name = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setInt(1, topWinner.getHappinessLevel());
        preparedStatement.setString(2, topWinner.getName());

        preparedStatement.executeUpdate();

    }

//    //    Update Animal Name
//    public void updateAnimalName(TopWinner topWinner) throws SQLException, IOException, ClassNotFoundException {
//        Connection connection = DatabaseConfiguration.getConnection();
//
//        String insertSql = "UPDATE animals SET name = (?) WHERE name = 'unknown';";
//
//
//        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
//        preparedStatement.setString(1, topWinner.getName());
//        preparedStatement.executeUpdate();
//    }

//    String insertSql = "INSERT INTO animals (`name`, color, age, gender, favoriteFoodName,"
//            + " favoriteActivityName, time, hungerLevel, happinessLevel, gameplayed)"
//            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
//            + " ON DUPLICATE KEY UPDATE"
//            + " gameplayed = gameplayed + 1;";
//
//            String insertSql = "UPDATE animals SET name = (?) WHERE name = 'unknown';";


    public TopWinner getTopWinner() {
        return topWinner;
    }

    public void setTopWinner(TopWinner topWinner) {
        this.topWinner = topWinner;
    }

    public Rescuer getRescuer() {
        return rescuer;
    }

    public void setRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}


