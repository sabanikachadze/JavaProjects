package TheShapeCalculator;

public abstract class Shape {
    protected String color;

    public Shape(String color){
        this.color = color;
    }
    public void displayColor(){
        System.out.println(color);
    }

    abstract void getArea();
    abstract void getPerimeter();
}
