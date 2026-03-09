package AnimalKIngdom2;

import java.util.ArrayList;

public class Dog extends Animal implements Trainable {
    private final ArrayList<String> tricks = new ArrayList<>();

    public Dog(String sound, String name, int age) {
        super(sound, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getSound());
    }

    @Override
    public boolean train(String trick) throws UntrainableAnimalException {
        if (trick.isEmpty()) return false;
        tricks.add(trick); // FIX: was tricks.add("trick") — added the word "trick" literally every time!
        return true;
    }

    @Override
    public void showTricks() {
        System.out.println(getName() + "'s tricks: " + tricks);
    }
}