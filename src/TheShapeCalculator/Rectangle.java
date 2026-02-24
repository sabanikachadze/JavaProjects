package TheShapeCalculator;

public class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public void getArea() {
        System.out.printf("Rectangle Area: %.1f%n", width * height);
    }

    public void getPerimeter() {
        System.out.printf("Rectangle Perimeter: %.1f%n", 2 * (width + height));
    }

}
