package AnimalKingdom;

public class Crocodile extends Reptile{
    public Crocodile(String name, int age) {
        super(name, age);
    }
    @Override
    String makeSound() {
        return "Croccodile noise";
    }

    @Override
    String getHabitat() {
        return "swamp";
    }
}
