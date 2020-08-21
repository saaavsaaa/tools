package date.iterator.tools.sort;

import date.iterator.tools.Printer;

public class MergeSort {
    // todo 完成后改为泛型，并用equals比较
    public static void sort(final int[] input) {
        if (input.length == 1) return;
//        Printer.INSTANCE.setWillPrint(true);
        split(0, input.length, input);
        // todo 用循环方法试试
//        loop_split(0, input.length, input);
//        Printer.INSTANCE.printArray(input);
    }

    /*
    * 0:splitPoint-1 , splitPoint:length-1
    */
    private static void split(final int low, final int high, final int[] input) {
        if (high - low == 1) { return ; }
        int splitPoint = (high + low) / 2;

        Printer.INSTANCE.printArray(low, high, input);

        split(low, splitPoint, input);
        split(splitPoint, high, input);

        collect(low, splitPoint, high, input);
        // unite(low, splitPoint, high, input);
    }

    private static void loop_split(final int low, final int high, final int[] input) {
        int cover = 0;
        int step = 1;
        while (cover < input.length) {
            cover = step * 2;

            for (int i = 0; i < input.length; i += cover) {
                int start = i + low;
                if (start + step > input.length) {
                    collect(i - cover, i, input.length, input);
                    // unite(i - cover, i, input.length, input);
                }
                collect(start, start+ step, start + 2 * step, input);
                // unite(start, start+ step, start + 2 * step, input);
            }
            Printer.INSTANCE.printArray(low, 2*step, input);

            step++;
        }
    }

    private static void collect(final int low, final int splitPoint, final int high, final int[] input) {
        if (high - low == 1) { return ; }
        int[] slide = new int[splitPoint - low];
        System.arraycopy(input, low, slide, 0, slide.length);
        int a = 0;
        int b = splitPoint;
        int index = low;
        while (a < splitPoint - low && index < high) {
            if (b == high) {
                input[index++] = slide[a++];
                continue;
            }
            if (slide[a] == input[b]) {
                input[index++] = slide[a++];
                input[index++] = input[b++];
            } else if (b < high) {
                input[index++] = slide[a] < input[b] ? slide[a++] : input[b++];
            }
        }
    }

    // 为了不申请空间，用了更多的循环次数，并非真正的归并，在极端情况下，归并前半段执行结束后，后半段还会内部继续比较
    // 虽然可以继续优化，不过就算了，轻易也用不上
    private static void unite(int low, int splitPoint, int high, final int[] input) {
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
    }
}
