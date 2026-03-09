package AnimalKingdom;

public class Cat extends Mammal{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Meow";
    }

    @Override
    String getHabitat() {
        return "Home";
    }
}
