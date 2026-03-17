package Generics;

import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (elements.isEmpty())
            throw new RuntimeException("Stack is empty");

        return elements.removeLast();
    }

    public T peek() {
        if (elements.isEmpty())
            throw new RuntimeException("Stack is empty");
        return elements.getLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        intStack.push(1);
        intStack.push(2);

        strStack.push("1");
        strStack.push("2");
        strStack.push("3");
        System.out.println(strStack.isEmpty());
    }
}
