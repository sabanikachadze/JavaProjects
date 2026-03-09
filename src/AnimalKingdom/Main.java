package AnimalKingdom;

public class Main {
    public static void main(String[] args){
        Cat cat = new Cat("Murtalo",1);
        Crocodile crocodile = new Crocodile("pepeto",8);
        Dog dog = new  Dog("cugariko",7);
        Eagle eagle = new Eagle("kako",2);
        Penguin penguin = new Penguin("kushia",5);
        Snake snake = new Snake("sisina",3);
        Whale whale = new Whale("vasia",20);

        Zoo zoo = new Zoo();

        zoo.addToZoo(cat);
        zoo.addToZoo(crocodile);
        zoo.addToZoo(eagle);
        zoo.addToZoo(penguin);
        zoo.addToZoo(dog);
        zoo.addToZoo(snake);
        zoo.addToZoo(whale);

        zoo.printAllAnimal();
    }
}
