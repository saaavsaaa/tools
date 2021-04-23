package date.iterator.tools.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {

    final Class<T> type;
    final T[] input;

    public QuickSort(Class<T> type, T[] input) {
        this.type = type;
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
        int divide = 0;
        // index = electPivot(input); 可以随机选三个，返回中间值的索引
        swap(low, (int) (System.currentTimeMillis() % (input.length - 1)));
        T pivot = input[low];
        for (int k = low + 1; k < high; k++) {
            if (input[k].compareTo(pivot) < 0) {
                swap(++divide, k);
            }
        }
        swap(low, divide);
        return divide;
    }

    public void swap(int a, int b) {
        T s = input[a];
        input[a] = input[b];
        input[b] = s;
    }
}
