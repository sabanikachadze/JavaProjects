package AnimalKingdom;

public abstract class Reptile extends Animal {

    public Reptile(String name, int age) {
        super(name, age);
    }

    public boolean canSwim(){
        return true;
    }
}
