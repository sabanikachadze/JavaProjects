package TheEmployPayroll;

public class FullTimeEmployee extends Employee {
    private final int monthlySalary = 3000;
    public FullTimeEmployee(String name, int hours) {
        super(name,hours);
    }

    public double calculateSalary(){
        return monthlySalary;
    }
}
