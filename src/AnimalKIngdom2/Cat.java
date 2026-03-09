package AnimalKIngdom2;

public class Cat extends Animal{
    public Cat(String sound, String name, int age) {
        super(sound, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getSound());
    }
}
