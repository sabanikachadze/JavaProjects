package GenericStuff;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public boolean pop() {
        if (stack.isEmpty()) return false;
        stack.removeLast();
        return true;
    }

    public T peek() {
        return stack.getLast();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
