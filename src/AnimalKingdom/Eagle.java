package AnimalKingdom;

public class Eagle extends Bird{
    public Eagle(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Eagle noise";
    }

    @Override
    String getHabitat() {
        return "Mountains";
    }
}
