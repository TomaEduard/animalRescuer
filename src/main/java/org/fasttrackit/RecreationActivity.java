package org.fasttrackit;

public class RecreationActivity  {

    private String name;

//
    public RecreationActivity(String name, Adoptator firstAdoptator, Cat firstAnimal) {
        this.name = name;
    }


//

    public void walking(Adoptator adoptatorName, Animal animalName) {
        System.out.println(adoptatorName.getName() + " just " + this.name +
                " with " + animalName.getName() + ".");
    }

//


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
