package AnimalKIngdom2;

public interface Trainable {
   boolean train(String trick) throws UntrainableAnimalException;
   void showTricks();
}
