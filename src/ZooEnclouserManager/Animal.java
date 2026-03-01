package ZooEnclouserManager;

public class Animal {
    protected final int id;
    protected final String name;
    protected final int age;
    protected boolean predator;
    protected boolean isFed;

    public Animal(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        predator = false;
        isFed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPredator() {
        this.predator = true;
    }

    public int getAge() {
        return age;
    }

    public void feed(){
        isFed = true;
    }

    public void sound(){
        System.out.println("Animal makes sound");
    }
}
