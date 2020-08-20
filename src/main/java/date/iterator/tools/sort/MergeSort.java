package date.iterator.tools.sort;

import date.iterator.tools.Printer;

public class MergeSort {
    // todo 完成后改为泛型，并用equals比较
    public static void sort(final int[] input) {
        if (input.length == 1) return;
//        Printer.INSTANCE.setWillPrint(true);
        split(0, input.length, input);
        Printer.INSTANCE.printArray(input);
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
        int l = low;
        int h = high;
        while (l < h) {
            int splitPoint = (h + l) / 2;

            Printer.INSTANCE.printArray(l, h, input);


        }
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
        Printer.INSTANCE.printArray(low, high, input);
        System.out.println("loop:" + loop);
        return low;
    }
}
