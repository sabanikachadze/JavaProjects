package ZooEnclouserManager;

public class Mammal extends Animal{
    protected final String furColor;

    public Mammal(int id, String name, int age, String furColor) {
        super(id, name, age);
        this.furColor = furColor;
    }

    @Override
    public void sound(){
        System.out.println("Roar!");
    }
}
