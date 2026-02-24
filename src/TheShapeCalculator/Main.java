package TheShapeCalculator;

public class Main {
    public static void main(String[] args){
        Circle circle = new Circle("Red",5);
        Rectangle rectangle = new Rectangle("Blue",8.4,23);

        circle.displayColor();
        circle.getArea();
        circle.getPerimeter();

        rectangle.displayColor();
        rectangle.getArea();
        rectangle.getPerimeter();

    }
}
