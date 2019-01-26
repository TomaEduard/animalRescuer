package org.fasttrackit;

public class Rescuer {

    private String name;
    private int moneyavaible;

    private int hungerLevel = 10;
    private int happinessLevel = 0;

//

    public Rescuer(String name, int moneyavaible) {
        this.name = name;
        this.moneyavaible = moneyavaible;
    }

    //

    public void feed(Animal animal, AnimalFood food) {

        if (hungerLevel > 1) {
            hungerLevel--;
            System.out.println(this.name + " just gave some " + food.getName() +
                    " to " + animal.getName() + "and now the hunger level is: " + hungerLevel);

            if (animal.getFavoriteFoodName() == food.getName()) {
                happinessLevel++;
                System.out.println("The happiness level is: " + happinessLevel);
            }

        } else {
            System.out.println(animal.getName() + " feels the village!");
        }
    }

    public void entertain(Animal animal, RecreationActivity recreationActivity) {

        if (animal.getFavoriteActivityName() == recreationActivity.getName()) {
            happinessLevel += 2;
            System.out.println(this.name + " just have entertained with " +
                    animal.getName() + " in the " + recreationActivity.getName() +
                    " activity, and now the happiness level is: " + happinessLevel);

        } else if (happinessLevel < 10) {
            happinessLevel++;
            System.out.println(this.name + " just have entertained with " +
                    animal.getName() + " in the " + recreationActivity.getName() +
                    " activity, and now the happiness level is: " + happinessLevel);
        }

/*
            if (happinessLevel < 10) {
                happinessLevel++;
                if (animal.getFavoriteActivityName() == recreationActivity.getName()) {
                    happinessLevel ++;
                }
                System.out.println(this.name + " just have entertained with " +
                        animal.getName() + " in the " + recreationActivity.getName() +
                        " activity, and now the happiness level is: " + happinessLevel);
            }
*/


        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public int getMoneyavaible () {
            return moneyavaible;
        }

        public void setMoneyavaible ( int moneyavaible){
            this.moneyavaible = moneyavaible;
        }

        public int getHungerLevel () {
            return hungerLevel;
        }

        public void setHungerLevel ( int hungerLevel){
            this.hungerLevel = hungerLevel;
        }

        public int getHappinessLevel () {
            return happinessLevel;
        }

        public void setHappinessLevel ( int happinessLevel){
            this.happinessLevel = happinessLevel;
        }


    }
