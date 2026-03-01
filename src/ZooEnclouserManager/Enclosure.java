package ZooEnclouserManager;

import java.util.Arrays;

public class Enclosure {
    private final int maxCapacity;
    private final Animal[] animals;
    private int animalCount;

    public Enclosure(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.animals = new Animal[maxCapacity];
    }

    public boolean addAnimal(Animal animal){
        if(animalCount == maxCapacity) return false;
        for(int i = 0; i < animalCount; i++){
            if(animals[i].equals(animal)) return false;
        }
        for(int i = 0; i < animalCount; i++){
            if( animal.predator && !animals[i].predator) return false;
        }
        animals[animalCount++] = animal;
        return true;
    }

    public boolean removeAnimal(Animal animal){
        boolean animalRemoved = false;
        for(int i= 0; i < animalCount; i++){
            if(animals[i].equals(animal)){
                animalRemoved = true;
            }else if(animalRemoved){
                animals[i-1] = animals[i];
            }
        }
        animalCount--;
        return animalRemoved;
    }

    public void feedAll(){
        for(int i= 0; i < animalCount; i++){
            animals[i].feed();
        }
    }

    public int getTotalAnimals() {
        return animalCount;
    }

    public Animal[] getAnimals(){
          return Arrays.copyOf(animals,animalCount);
    }
}
