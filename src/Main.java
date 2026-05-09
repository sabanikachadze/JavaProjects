import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of the most beautiful creature: ");
        String name = sc.nextLine();

        if(name.equalsIgnoreCase("Olga")){
            System.out.println("You are correct!");
        }else{
            System.out.println("Nahhhhh");
        }

        sc.close();
    }
}