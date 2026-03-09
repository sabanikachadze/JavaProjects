package ShapeAreaCalculator;

import java.util.ArrayList;

public class ShapeCollection {
    private final ArrayList<Shape> geometricFigures = new ArrayList<>();

    public void addShape(Shape shape) throws InvalidShapeException {
        if (shape == null) throw new InvalidShapeException("- Invalid shape tried to go inside shapes collection!");
        geometricFigures.add(shape);
    }

    public Shape getLargest() {
        Shape largest = geometricFigures.getFirst();

        for (Shape shape : geometricFigures) {
            if (largest.area() < shape.area()) {
                largest = shape;
            }
        }
        return largest;
    }

    public Shape getSmallest() {
        Shape smallest = geometricFigures.getFirst();

        for (Shape shape : geometricFigures) {
            if (smallest.area() > shape.area()) {
                smallest = shape;
            }
        }
        return smallest;
    }

    public double getTotalArea() {
        double total = 0.0;

        for (Shape shape : geometricFigures) {
            total += shape.area();
        }
        return total;
    }

    public void printAll() {
        for (Shape shape : geometricFigures) {
            System.out.println(shape.describe());
        }
    }

    public void bubbleSortByArea() {

        int n = geometricFigures.size();

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                Shape current = geometricFigures.get(j);
                Shape next = geometricFigures.get(j + 1);

                if (current.area() > next.area()) {

                    geometricFigures.set(j, next);
                    geometricFigures.set(j + 1, current);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
