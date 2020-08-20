package date.iterator.tools;

public class MergeSort {
    public static void sort(final int[] input) {
        if (input.length == 1) return;
        split(0, input.length, input);
    }

    /*
    * 0:splitPoint-1 , splitPoint:length-1
    */
    private static void split(final int low, final int high, final int[] input) {
        if (high - low == 1) { System.out.println("return:" + input[low]);; return; }
        int splitPoint = (high + low) / 2;

        test(low, high, splitPoint, input);

        split(low, splitPoint, input);
        split(splitPoint, high, input);
    }

    private static void test(final int low, final int high, final int splitPoint, final int[] input) {
        int[] a = new int[splitPoint];
        int[] b = new int[high - splitPoint];
        System.arraycopy(input, 0, a, 0, splitPoint);
        System.arraycopy(input, splitPoint, b, 0, high - splitPoint);
        Printer.printArray(a);
        System.out.println("---------------");
        Printer.printArray(b);
        System.out.println("---------------");
    }
}
