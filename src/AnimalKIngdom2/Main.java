package AnimalKIngdom2;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Animal bird  = new Bird("chik chiki", "chiora", 5);
        Animal dog   = new Dog("Barking", "Yursha", 5);
        Animal snake = new Snake("rattling", "rattleSnake", 5);
        Animal cat   = new Cat("Meow!", "murtalo", 5);

        zoo.addAnimal(bird);
        zoo.addAnimal(dog);
        zoo.addAnimal(snake);
        zoo.addAnimal(cat);

        zoo.allMakeSounds();
        System.out.println("---");
        zoo.showTrainableAnimals();

        // FIX: snake is declared as Animal — Animal has no train() method
        // Solution: cast to Trainable first, then call train()
        // This works because Snake now implements Trainable
        if (snake instanceof Trainable) {
            try {
                ((Trainable) snake).train("roll over");
            } catch (UntrainableAnimalException e) {
                System.out.println(e.getMessage()); // prints: "rattleSnake cannot be trained!"
            }
        }
    }
}