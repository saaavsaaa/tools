package date.iterator.tools.sort;

import date.iterator.tools.Printer;

public class MergeSort {
    // todo 完成后改为泛型，并用equals比较
    public static void sort(final int[] input) {
        if (input.length == 1) return;
//        Printer.INSTANCE.setWillPrint(true);
//        split(0, input.length, input);
        loop_split(0, input.length, input);
//        Printer.INSTANCE.printArray(input);
    }

    /*
    * 0:splitPoint-1 , splitPoint:length-1
    */
    private static int split(final int low, final int high, final int[] input) {
        if (high - low == 1) { return low; }
        int splitPoint = (high + low) / 2;

        Printer.INSTANCE.printArray(low, high, input);

        split(low, splitPoint, input);
        split(splitPoint, high, input);

        return unite(low, splitPoint, high, input);
    }

    private static void loop_split(final int low, final int high, final int[] input) {
        int cover = 0;
        int step = 1;
        while (cover < input.length) {
//            int swap = input[low];
//            if (input[low] > input[low + step]) {
//                unite(low, low + step, low + 2*step, input);
//            }
            cover = step * 2;

            for (int i = 0; i < input.length; i += cover) {
                int start = i + low;
                if (start + step > input.length) {
                    unite(i - cover, i, input.length, input);
                }
                unite(start, start+ step, start + 2 * step, input);
            }
            Printer.INSTANCE.printArray(low, 2*step, input);

            step++;
        }
    }

    private static void collect(int low, int splitPoint, int high, final int[] input) {

    }

    // 为了不申请空间，用了更多的循环次数，并非真正的归并，在极端情况下，归并前半段执行结束后，后半段还会内部继续比较
    private static int unite(int low, int splitPoint, int high, final int[] input) {
        if (high > input.length) high = input.length;
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
            if (a >= b) {
                if (high - a < 2) { b++; continue; }
                splitPoint = (a + high) / 2;
                b = splitPoint;
            }
        }
        Printer.INSTANCE.printArray(low, high, input);
        System.out.println("loop:" + loop);
        return low;
    }
}
