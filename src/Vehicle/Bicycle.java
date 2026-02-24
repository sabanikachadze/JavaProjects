package Vehicle;

public class Bicycle implements Vehicle{
    protected final int speed = 30;

    public void startEngine(){ System.out.println("No engine!");}

    public void stopEngine(){System.out.println("No engine!");}

    public int getSpeed(){ return speed;}
}