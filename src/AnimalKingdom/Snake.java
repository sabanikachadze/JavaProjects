package AnimalKingdom;

public class Snake extends Reptile{

    public Snake(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Snake noise";
    }

    @Override
    String getHabitat() {
        return "Swamp";
    }
}
