package ZooEnclouserManager;

public class Bird extends Animal{
    protected final int wingspan;

    public Bird(int id, String name, int age, int wingspan) {
        super(id, name, age);
        this.wingspan = wingspan;
    }

    @Override
    public void sound(){
        System.out.println("Squick!");
    }
}
