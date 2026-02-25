package CopyConstructor;

public class Main {
    public static void main(String[] args){
        Car car1 = new Car("Red","Toyota",2020);
        Car car2 = new Car(car1);
        car2.color = "Blue";

        System.out.println("car1 :" + car1.toString());
        System.out.println("car2 :" + car2.toString());
    }
}
