package AnimalKIngdom2;

import java.util.ArrayList;

public class Bird extends Animal implements Trainable{
    private ArrayList<String> tricks = new ArrayList<>();
    public Bird(String sound, String name, int age) {
        super(sound, name, age);
    }

    @Override
    public boolean train(String trick) {
        if(trick.isEmpty()) return false;
        tricks.add("trick");
        return true;
    }

    @Override
    public void showTricks() {
        for(String trick : tricks){
            System.out.println(trick);
        }
    }

    @Override
    public void makeSound() {
        System.out.println(getSound());
    }
}
