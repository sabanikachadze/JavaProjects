package ShapeAreaCalculator;

public class Rectangle extends Shape implements Resizable,AreaComparable{
    private double width;
    private double height;
    public Rectangle(String color, double width, double height) throws InvalidShapeException{
        super(color);
        if(width <= 0 || height <= 0) throw new InvalidShapeException("Sides can't be zero or negative!");
        this.width = width;
        this.height = height;
    }

   @Override
    public int compareTo(Shape other) {
        return 0;
    }

    @Override
    double area() {
        return width * height;
    }
    @Override
    double perimeter() {
        return 2 * ( width + height);
    }

    @Override
    String describe() {
        return String.format( getClass().getSimpleName() +
        " | color=%s | width = %.1f, height = %.1f | area=%.2f | perimeter=%.2f",
                getColor(), width ,height, area(), perimeter());
    }

    @Override
    public void resize(double factor) {
        width *= factor;
        height *= factor;
    }
}
