package TheAnimalKingdom;

public class Main {
    public static void main(String[] args) {
        Swimmable[] swimmers = new Swimmable[3];
        swimmers[0] = new Duck();
        swimmers[1] = new Fish();
        swimmers[2] = new Dog();

        for (Swimmable s : swimmers) {
            s.swim();
        }
    }
}
