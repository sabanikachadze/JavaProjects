package AnimalKIngdom2;

public class UntrainableAnimalException extends Exception {
    // FIX: without this, e.getMessage() returns null — useless in catch blocks
    public UntrainableAnimalException(String animalName) {
        super(animalName + " cannot be trained!");
    }
}