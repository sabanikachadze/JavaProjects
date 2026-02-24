package TheEmployPayroll;

public class FreelanceEmployee extends Employee {
    protected int ratePerHour;
    public FreelanceEmployee(String name, int hours,int ratePerHour) {
        super(name,hours);
        this.ratePerHour = ratePerHour;
    }

    public double calculateSalary(){
        return  ratePerHour * hours;
    }
}
