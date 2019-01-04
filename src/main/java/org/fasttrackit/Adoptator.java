package org.fasttrackit;

public class Adoptator {

    private String name;
    private int moneyavaible;
    private Animal myAnimal;

//

    public Adoptator(String name, Animal Animal) {
        this.name = name;
        this.myAnimal = myAnimal;
    }

//

    public void Feed(Animal animal, AnimalFood food) {

        System.out.println(this.name + " just gave some " +
                food.getName() + " food to " + animal.getName() + ".");
    }


//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneyavaible() {
        return moneyavaible;
    }

    public void setMoneyavaible(int moneyavaible) {
        this.moneyavaible = moneyavaible;
    }

}
