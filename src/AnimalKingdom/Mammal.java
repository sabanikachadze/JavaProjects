package AnimalKingdom;

public abstract class Mammal extends Animal {
    public Mammal(String name, int age) {
        super(name, age);
    }

    public boolean isDomesticated() {
        return true;
    }
}
