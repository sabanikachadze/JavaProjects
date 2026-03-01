package ZooEnclouserManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Mammal lion = new Mammal(1 ,"lion", 5, "goldish");
        Bird falcon = new Bird(2 ,"lion", 5, 30);
        Reptile lizard = new Reptile(3 ,"ComodoDragon", 5, 300);

        Enclosure zoo = new Enclosure(5);

        zoo.addAnimal(lion);
        zoo.addAnimal(falcon);
        zoo.removeAnimal(lion);
        zoo.addAnimal(lizard);
        lion.setPredator();
        zoo.addAnimal(lion);


        System.out.println(Arrays.toString(zoo.getAnimals()));

    }
}
