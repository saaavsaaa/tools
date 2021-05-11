package date.iterator.tools.sort;

import date.iterator.tools.util.Other;

public class QuickSort<T extends Comparable<T>> {

    final T[] input;

    public QuickSort(T[] input) {
        this.input = input;
    }

    public void sort() {
        sort(0, input.length);
    }

    public void sort(int low, int high) {
        if (high - low < 2) return;
        int divide = partition(low, high);
        sort(low, divide);
        sort(divide + 1, high);
    }
    public int partition(int low, int high) {
        int divide = low;
        // index = electPivot(input); 可以随机选三个，返回中间值的索引
        Other.swap(input, low, low + (int) (System.currentTimeMillis() % (high - low)));
        T pivot = input[low];
        for (int k = low + 1; k < high; k++) {
            if (input[k].compareTo(pivot) < 0) {
                Other.swap(input, ++divide, k);
            }
        }
        Other.swap(input, low, divide);
        return divide;
    }
}
