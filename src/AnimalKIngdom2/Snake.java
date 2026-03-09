package AnimalKIngdom2;


public class Snake extends Animal implements Trainable {

    public Snake(String sound, String name, int age) {
        super(sound, name, age);
    }

    @Override
    public void shoTricks() {
        System.out.println(getName() + " has no tricks.");
    }

    @Override
    public void makeSound() {
        System.out.println(getSound());
    }

    @Override
    public boolean train(String trick) throws UntrainableAnimalException {
        throw new UntrainableAnimalException(getName());
    }

}