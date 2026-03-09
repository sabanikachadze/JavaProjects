package ShapeAreaCalculator;

public class Main {
    public static void main(String[] args) {

        // ─── CREATE SHAPES ───────────────────────────────────────
        try {
            Circle circle       = new Circle("red", 5);
            Rectangle rectangle = new Rectangle("blue", 4, 6);
            Square square       = new Square("green", 4);
            Triangle triangle   = new Triangle("yellow", 3, 4, 5);

            // ─── DESCRIBE EACH ───────────────────────────────────
            System.out.println("=== Shapes ===");
            System.out.println(circle.describe());
            System.out.println(rectangle.describe());
            System.out.println(square.describe());
            System.out.println(triangle.describe());

            // ─── RESIZE ──────────────────────────────────────────
            System.out.println("\n=== After Resize x2 ===");
            circle.resize(2);
            rectangle.resize(2);
            square.resize(2);
            triangle.resize(2);

            System.out.println(circle.describe());
            System.out.println(rectangle.describe());
            System.out.println(square.describe());
            System.out.println(triangle.describe());

            // ─── COMPARE ─────────────────────────────────────────
            System.out.println("\n=== Compare ===");
            int result = circle.compareTo(rectangle);
            if (result > 0) System.out.println("Circle is bigger than Rectangle");
            if (result < 0) System.out.println("Rectangle is bigger than Circle");
            if (result == 0) System.out.println("Circle and Rectangle are equal");

            // ─── SHAPE COLLECTION ────────────────────────────────
            System.out.println("\n=== Collection ===");
            ShapeCollection collection = new ShapeCollection();
            collection.addShape(circle);
            collection.addShape(rectangle);
            collection.addShape(square);
            collection.addShape(triangle);

            System.out.println("Largest:    " + collection.getLargest().describe());
            System.out.println("Smallest:   " + collection.getSmallest().describe());
            System.out.printf("Total area: %.2f%n", collection.getTotalArea());

            System.out.println("\n=== All Shapes ===");
            collection.printAll();

        } catch (InvalidShapeException e) {
            System.out.println("Shape error: " + e.getMessage());
        }

        // ─── TEST INVALID TRIANGLE ───────────────────────────────
        System.out.println("\n=== Invalid Shape Test ===");
        try {
            Triangle invalid = new Triangle("black", 1, 2, 10);
        } catch (InvalidShapeException e) {
            System.out.println("Caught: " + e.getMessage()); // should print
        }

        // ─── TEST INVALID CIRCLE ─────────────────────────────────
        try {
            Circle invalid = new Circle("pink", -3);
        } catch (InvalidShapeException e) {
            System.out.println("Caught: " + e.getMessage()); // should print
        }
    }
}