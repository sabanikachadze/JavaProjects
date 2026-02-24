package TheSmartHome;

public class SmartLight implements Switchable,Dimmable{




       public void switchOn(){System.out.println("Smart Light: ON");}
       public void switchOff(){System.out.println("Smart Light: OFF");}
       public void dimLight( int brightness){
        System.out.println("Smart Light Brightness Set to " + brightness + "%" );
       };
}
