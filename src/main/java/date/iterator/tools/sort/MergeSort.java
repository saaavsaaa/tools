package date.iterator.tools.sort;

import date.iterator.tools.Printer;

public class MergeSort {

    // 除非极端不想新开辟空间，否则不推荐使用
    private boolean saveSpace;

    // todo 完成后改为泛型，并用equals比较
    public void circulatingSort(final int[] input) {
        if (input.length == 1) return;
        loop(0, input.length, input);
    }

    public void recursiveSort(final int[] input) {
        if (input.length == 1) return;
        split(0, input.length, input);
    }

    /*
    * 0:splitPoint-1 , splitPoint:length-1
    */
    private void split(final int low, final int high, final int[] input) {
        if (high - low == 1) { return ; }
        int splitPoint = (high + low) / 2;

        // Printer.INSTANCE.printArray(low, high, input);
        Printer.INSTANCE.runAt();

        split(low, splitPoint, input);
        split(splitPoint, high, input);

        gather(low, splitPoint, high, input);
    }

    private void loop(final int low, final int high, final int[] input) {
        int step = 1;
        int cover = 2;
        while (cover < input.length) {
            for (int i = 0; i < input.length; i += cover) {
                Printer.INSTANCE.runAt();
                int start = i + low;
                int a = start;
                int b = start+ step;
                int c = start + 2 * step;
                if (start + step >= input.length) {
                    a = i - cover;
                    b = i;
                    c = input.length;
                }
                gather(a, b, c, input);
            }
            Printer.INSTANCE.printArray(low, 2*step, input);

            step++;
            cover = step * 2;
        }
    }

    private void gather(final int low, final int splitPoint, final int high, final int[] input) {
        if (saveSpace) {
            collect(low, splitPoint, high, input);
        } else {
            unite(low, splitPoint, high, input);
        }
    }

    private void collect(final int low, final int splitPoint, final int high, final int[] input) {
        int[] slide = new int[splitPoint - low];
        System.arraycopy(input, low, slide, 0, slide.length);
        int a = 0;
        int b = splitPoint;
        int index = low;
        while (a < splitPoint - low && index < high) {
            Printer.INSTANCE.runAt();
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
    private void unite(int low, int splitPoint, int high, final int[] input) {
        if (high > input.length) high = input.length;
        int a = low;
        int b = splitPoint;
        while (a < splitPoint && b < high) {
            Printer.INSTANCE.runAt();
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
    }

    public void setSaveSpace(boolean saveSpace) {
        this.saveSpace = saveSpace;
    }
}
