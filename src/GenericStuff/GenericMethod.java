package GenericStuff;

public class GenericMethod {
    public <T> T getLast(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        return arr[arr.length - 1];
    }
}
