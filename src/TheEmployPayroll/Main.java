package TheEmployPayroll;

public class Main {
    public static void main(String[] args){
        FullTimeEmployee FullTime = new FullTimeEmployee("Saba",150);
        FreelanceEmployee Freelance = new FreelanceEmployee("Vaska",90,30);

        FullTime.displayInfo();
        System.out.println(FullTime.calculateSalary());

        Freelance.displayInfo();
        System.out.println(Freelance.calculateSalary());
    }
}
