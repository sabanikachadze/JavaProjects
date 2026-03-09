package AnimalKingdom;

public abstract class Animal{
    final String name;
    final int age;
    private boolean endangered = false;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String makeSound();
    abstract String getHabitat();

    public boolean isEndangered() {
        return endangered;
    }

    public void endangered(){endangered = true;}

    public final String describe() {
        return name + " is a " + age + "-year-old " +
               getClass().getSimpleName() +
               " living in " + getHabitat() +
               ". Says: " + makeSound();
    }
}
