package org.fasttrackit;

public class RecreationActivity  {

    private String name;

//
    public RecreationActivity(String name) {
        this.name = name;
    }


//

    public void walking(Adoptator adoptatorName, Animal animalName) {
        System.out.println(adoptatorName.getName() + " just " + this.name +
                " with " + animalName.getName() + ".");
    }

//

    public String getType() {
        return name;
    }

    public void setType(String type) {
        this.name = type;
    }

}
