package date.iterator.tools.sort;

import java.lang.reflect.Array;

public class QuickSort<T extends Comparable<T>> {
    int high = 0;
    int low = 0;
    int divide = 0;
    T pivot;
    final Class<T> type;

    public QuickSort(Class<T> type) {
        this.type = type;
    }

    public void sort(final T[] input) {
        pivot = electPivot(input);
    }

    T electPivot(final T[] input) {
        T one = input[(int) (System.currentTimeMillis() % input.length)];
        T two = input[(int) ((System.currentTimeMillis()+100) % input.length)];
        T three = input[(int) (System.nanoTime() % input.length)];

        T[] candidates = (T[]) Array.newInstance(type, 3);
        int r = one.compareTo(two);
        if (r == 0) {
            return one;
        }
        int index1 = r + 1;
        int index2 = index1 - r;
        candidates[index1] = one;
        candidates[index2] = two;
        if (three.compareTo(candidates[0]) < 0) {
            return candidates[0];
        } else {
            return three.compareTo(candidates[1]) > 0 ? three : candidates[1];
        }
    }
}
