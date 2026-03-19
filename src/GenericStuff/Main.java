package GenericStuff;

public class Main {
    public static void main(String[] args) {
    Pair<String, Integer> p = new Pair<>("age", 25);
    System.out.println(p.getFirst());  // age
    System.out.println(p.getSecond()); // 25
    Pair<Integer, String> swapped = p.swap();
    System.out.println(swapped.getFirst());  // 25
    System.out.println(swapped.getSecond()); // age
    }
}
