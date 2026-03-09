package AnimalKingdom;

public class Whale extends Mammal{

    public Whale(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean isDomesticated(){
        return false;
    }

    @Override
    String makeSound() {
        return "Whale noise";
    }

    @Override
    String getHabitat() {
        return "ocean";
    }
}
