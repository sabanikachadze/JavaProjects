package AnimalKingdom;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Animal> zoo = new ArrayList<Animal>();
    List<Animal> habitat = new ArrayList<Animal>();

    public void addToZoo(Animal a){
        zoo.add(a);
    }
    public void printAllAnimal(){
        for(Animal anm: zoo){
            System.out.println(anm.describe());
        }
    }

    public long countAnimals(){
        return zoo.stream().filter(Animal::isEndangered).count();
    }
}
