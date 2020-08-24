package date.iterator.tools.sort;

import date.iterator.tools.Printer;

// todo 完成后改为泛型，并用equals比较
public class MergeSort {

    // 除非极端不想新开辟空间，否则不推荐使用
    private boolean saveSpace;

    public void sort(final int[] input) {
        recursiveSort(input);
    }

    /*
    * 突发奇想，想用循环试试，不过效果并不好，由于递归是在以切分的基础上再次切分，而这个循环是每次重新分，所以递归的效率比这个循环好
    */
    public void circulatingSort(final int[] input) {
        if (input.length == 1) return;
        loop(0, input.length, input);
    }

    /*
    * 递做气氛，归做排序，递归都用上了
    */
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
            step *= 2;
            cover = step * 2;
        }
    }

    private void gather(final int low, final int splitPoint, final int high, final int[] input) {
        if (!saveSpace) {
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

    // 为了不申请空间，用了更多的循环次数，并非真正的归并
    // 感觉挺有意思，但是不实用，写着玩的
    private void unite(final int low, final int splitPoint, int high, final int[] input) {
        if (high > input.length) high = input.length;
        if (high - low == 1) return;
        int a = low;
        int b = splitPoint;

        while (a < splitPoint || b < high) {
            Printer.INSTANCE.runAt();
            boolean swapped = false;
            if (input[a] == input[b]) {
                a++;
                swap(a, b, input);
                swapped = true;
            } else if (input[a] > input[b])  {
                swap(a, b, input);
                swapped = true;
            }
            a++;

            if (swapped) { //需要把current到splitPoint，依次后移，然后b++，接着才能再归并
                if (b != a) {
                    int current = input[b];
                    int position = b;
                    while (position > a) {
                        input[position] = input[position--];
                    }
                    input[position] = current;
                }
                b++;
            }
        }
        Printer.INSTANCE.printArray(low, high, input);
    }

    private boolean check(final int a, final int b, final int[] input) {
        int low = a;
        boolean swapped = false;
        if (input[low] == input[b]) {
            low++;
            swap(low, b, input);
            swapped = true;
        } else if (input[a] > input[b])  {
            swap(a, b, input);
            swapped = true;
        }
        low++;

        if (swapped) { //需要把current到splitPoint，依次后移，然后b++，接着才能再归并
            int current = input[b];
            int position = b;
            while (position > low) {
                input[position] = input[position--];
            }
            input[position] = current;
        }
        return swapped;
    }

    private void swap(final int a, final int b, final int[] input) {
        if (input[a] > input[b]) {
            int current = input[a];
            input[a] = input[b];
            input[b] = current;
        }
    }

    public void setSaveSpace(boolean saveSpace) {
        this.saveSpace = saveSpace;
    }
}
