package AnimalKIngdom2;

import java.util.ArrayList;

public class Dog extends Animal implements Trainable {
    private ArrayList<String> tricks = new ArrayList<>();

    public Dog(String sound, String name, int age) {
        super(sound, name, age);
    }

    @Override
    public boolean train(String trick) throws UntrainableAnimalException {
        if (trick.isEmpty()) return false;
        tricks.add(trick); // FIX: was tricks.add("trick") — added the word "trick" literally every time!
        return true;
    }

    @Override
    public void showTricks() { // FIX: typo "shoTricks" → "showTricks"
        System.out.println(getName() + "'s tricks: " + tricks);
    }
}