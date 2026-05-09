package LibraryManagmentSystem;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CheckAccess.startUsing(2041, "Bill G.");
        CheckAccess.startUsing(2420, "George B.");
        CheckAccess.startUsing(2437, "Phillip K.");
        CheckAccess.startUsing(2041, "Bill G.");
        CheckAccess.print();
        CheckAccess.print();
        CheckAccess.print();
        CheckAccess.print();
        CheckAccess.print();
        CheckAccess.print();

    }
}

class CheckAccess {
    private static Map<Integer, String> map = new HashMap<>();
    public static void startUsing(int id, String name) {
        if(canUse(id)) {
            map.put(id, name);
            System.out.println("access allowed");
        } else {
            System.out.println("access denied");
        }
    }
    public static boolean canUse(int id) {
        final int MAX_NUM = 2;
        int currNum = 0;
        if(!map.containsKey(id))
            currNum = map.size();
        return currNum < MAX_NUM;
    }

    public static void print(){
        System.out.println(map);
    }
}