package TheEmployPayroll;

public abstract class Employee {
    protected String name;
    protected int hours;
         public Employee(String name, int hours){
            this.name = name;
            this.hours = hours;
         }
         public void displayInfo(){
            System.out.println("Name: " + name + " -- Hours: " + hours);
         }

         abstract double calculateSalary();
}
