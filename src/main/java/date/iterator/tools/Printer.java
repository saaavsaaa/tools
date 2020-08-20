package date.iterator.tools;

public class Printer {

    public static void printArray(final int[] list) {
        for (int t : list) {
            System.out.println(t);
        }
    }

    public static <T> void printArray(final T[] list) {
        for (T t : list) {
            System.out.println(t);
        }
    }
}
