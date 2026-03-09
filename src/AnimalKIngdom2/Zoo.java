package AnimalKIngdom2;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals = new ArrayList<>();

    public boolean addAnimal(Animal animal) {
        if (animal == null) return false;
        animals.add(animal);
        return true;
    }

    public void allMakeSounds() {
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void showTrainableAnimals() {
        for (Animal animal : animals) {
            if (animal instanceof Trainable) {
                System.out.println(animal.toString());
            }
        }
    }
}