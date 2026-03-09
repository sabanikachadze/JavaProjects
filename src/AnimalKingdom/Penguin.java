package AnimalKingdom;

public class Penguin extends Bird{

    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean canFly(){
        return false;
    }

    @Override
    String makeSound() {
        return "penguin noises";
    }

    @Override
    String getHabitat() {
        return "Antarctic";
    }
}
