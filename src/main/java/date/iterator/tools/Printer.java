package date.iterator.tools;

public class Printer {

    public static void printArray(final int[] list) {
        printArray(0 , list.length, list);
    }

    public static void printArray(final int low, final int high, final int[] list) {
        System.out.println("---------------------------------------------------");
        int index = low;
        while (index < high) {
            System.out.println(list[index]);
            index++;
        }
        System.out.println("---------------------------------------------------");
    }

    public static <T> void printArray(final T[] list) {
        for (T t : list) {
            System.out.println(t);
        }
    }
}
