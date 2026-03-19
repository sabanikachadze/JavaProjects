package GenericStuff;

public class Main {
    public static void main(String[] args) {
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println(stack.peek()); // 3 — still there
System.out.println(stack.pop());  // 3 — now removed
System.out.println(stack.size()); // 2
    }
}
