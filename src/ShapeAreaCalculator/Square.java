package ShapeAreaCalculator;

public class Square extends Rectangle{
    public Square(String color, double side) throws InvalidShapeException{
        super(color, side, side);
    }
}
