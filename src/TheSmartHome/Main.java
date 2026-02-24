package TheSmartHome;

public class Main {
    public static void main(String[] args) {
        BasicLight basicLight = new BasicLight();
        SmartLight smartLight = new SmartLight();
        SmartTv smartTv = new SmartTv();

        basicLight.switchOn();
        basicLight.switchOff();
        System.out.println("-------");
        smartLight.switchOn();
        smartLight. dimLight(100);
        smartLight.switchOff();
        System.out.println("-------");
        smartTv.switchOn();
        smartTv.switchOff();

    }
}