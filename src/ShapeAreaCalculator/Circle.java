package ShapeAreaCalculator;

public class Circle extends Shape implements Resizable{
    private double radius;
    public Circle(String color,double radius) throws InvalidShapeException {
        super(color);
        if(radius <= 0) throw new InvalidShapeException("Radius cannot be negative or zero");
        this.radius = radius;
    }


    int compareTo(Shape other) {
        return 0;
    }

    @Override
    double area() {
        return Math.PI * ( radius * radius);
    }

    @Override
    double perimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    String describe() {
         return String.format("Circle | color=%s | radius=%.1f | area=%.2f | perimeter=%.2f",
                getColor(), radius, area(), perimeter());
    }

    @Override
    public void resize(double factor) {
        this.radius *= factor;
    }
}
