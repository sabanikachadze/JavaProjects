package CoordinateParser;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        CoordinationParser parser = new CoordinationParser();
         System.out.println(Arrays.toString(parser.parse("A6")));
    }
}
