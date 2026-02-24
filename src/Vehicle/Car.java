package Vehicle;

public class Car implements Vehicle{
    protected final int speed = 180;

    public void startEngine(){ System.out.println("Car engine started!");}

    public void stopEngine(){System.out.println("Car engine stopped!");}

    public int getSpeed(){ return speed;}
}
