package TheSmartHome;

public class BasicLight implements Switchable{
    public void switchOn(){
        System.out.println("Basic Light: ON");
    }
    public void switchOff(){
        System.out.println("Basic Light: OFF");
    }
}
