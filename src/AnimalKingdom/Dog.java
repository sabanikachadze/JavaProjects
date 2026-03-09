package AnimalKingdom;

public class Dog extends Mammal{
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Bark";
    }

    @Override
    String getHabitat() {
        return "Home";
    }
}
