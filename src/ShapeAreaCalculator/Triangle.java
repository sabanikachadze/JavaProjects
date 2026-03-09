package ShapeAreaCalculator;

public class Triangle extends Shape implements Resizable, AreaComparable {
    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) throws InvalidShapeException {
        super(color);
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new InvalidShapeException("These sides don't form a valid triangle");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String describe() {
        return String.format("Triangle | color=%s | sides=%.1f,%.1f,%.1f | area=%.2f | perimeter=%.2f",
                getColor(), a, b, c, area(), perimeter());
    }

    @Override
    public void resize(double factor) {
        a *= factor;
        b *= factor;
        c *= factor;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area(), other.area());
    }
}