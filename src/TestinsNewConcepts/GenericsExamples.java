package TestinsNewConcepts;

import java.util.ArrayList;

public class GenericsExamples {
    public static void main(String[] args){
        Printer<Integer> printer = new Printer<Integer>((int) 2.99999);
        Printer<Double> doublePrinter = new Printer<>(5.0);
        ArrayList<Boolean> carts = new ArrayList<>();

        doublePrinter.print();
        printer.print();
    }
}
