package Vehicle;

public class Main {
    public static void main(String[] args){
        Car car = new Car();
        Bicycle bicycle = new Bicycle();


        car.startEngine();
        System.out.println(car.getSpeed());
        car.stopEngine();

        System.out.println();

        bicycle.startEngine();
        System.out.println(bicycle.getSpeed());
        bicycle.stopEngine();
    }
}
