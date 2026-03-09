package AnimalKingdom;

public abstract class Bird extends Animal{
    public Bird(String name, int age) {
        super(name, age);
    }
    public  boolean canFly(){
        return true;
    };
}
