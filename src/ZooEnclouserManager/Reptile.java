package ZooEnclouserManager;

public class Reptile extends Animal{
    protected final int length;

    public Reptile(int id, String name, int age, int length) {
        super(id, name, age);
        this.length = length;
    }

    @Override
    public void sound(){
        System.out.println("sssssss!");
    }
}
