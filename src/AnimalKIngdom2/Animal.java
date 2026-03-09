package AnimalKIngdom2;

public abstract class Animal {
    private final String name;
    private final String sound;
    private int age;
    private boolean sleep = false;

    public Animal(String sound, String name, int age) {
        this.sound = sound;
        this.name = name;
        this.age = Math.max(age, 0);
    }

    public abstract void makeSound();

    public void sleep() {
        if (!sleep) sleep = true;
    }

    public boolean isSleep() { return sleep; }
    public String getSound() { return sound; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", sound='" + sound + '\'' +
                ", age=" + age +
                ", sleep=" + sleep +
                '}';
    }
}