package date.iterator.tools;

public class MergeSort {
    // todo 完成后改为泛型，并用equals比较
    public static void sort(final int[] input) {
        Printer.printArray(input);
        System.out.println("---------------");
        if (input.length == 1) return;
        split(0, input.length, input);
        Printer.printArray(input);
    }

    /*
    * 0:splitPoint-1 , splitPoint:length-1
    */
    private static int split(final int low, final int high, final int[] input) {
        if (high - low == 1) { return low; }
        int splitPoint = (high + low) / 2;

//        test(low, high, splitPoint, input);

        split(low, splitPoint, input);
        split(splitPoint, high, input);

        return unite(low, splitPoint, high, input);
    }

    private static int unite(final int low, final int splitPoint, final int high, final int[] input) {
        int a = low;
        int b = splitPoint;
        int loop = 0;
        while (a < splitPoint && b < high) {
            loop++; // 看下能不能优化循环次数
            int currentA = input[a];
            int currentB = input[b];
            if (currentA > currentB)  {
                input[a] = currentB;
                input[b] = currentA;
            }
            a++;
        }
        System.out.println("loop:" + loop);
        return low;
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
