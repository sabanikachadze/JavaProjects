package TheShapeCalculator;

public class Circle extends Shape {
    protected double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void getArea() {
        System.out.printf("Circle Area: %.1f%n", Math.PI * radius * radius);
    }

    public void getPerimeter() {
        System.out.printf("Circle Perimeter: %.1f%n%n", 2 * Math.PI * radius);
    }
}
