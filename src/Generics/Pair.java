package Generics;

public class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public Pair<S, F> swap() {
        return new Pair<>(second, first);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }


    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("hello", 42);
        System.out.println(p.getFirst());   // hello
        System.out.println(p.getSecond());  // 42

        Pair<Integer, String> swapped = p.swap();
        System.out.println(swapped.getFirst());  // 42
        System.out.println(swapped.getSecond()); // hello

        System.out.println(Pair.max(10, 20));        // 20
        System.out.println(Pair.max("apple", "z"));  // z

         // Pair.max(new Object(), new Object());
    }
}
