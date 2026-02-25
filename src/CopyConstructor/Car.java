package CopyConstructor;

public class Car {
    public String color;
    public String brand;
    public int year;

    public Car(String color, String brand, int year) {
        this.color = color;
        this.brand = brand;
        this.year = year;
    }

    Car(Car other) {
        this.color = other.color;
        this.brand = other.brand;
        this.year = other.year;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%d",brand, color, year);
    }

}
