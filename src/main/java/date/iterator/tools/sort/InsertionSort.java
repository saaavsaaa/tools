package date.iterator.tools.sort;

import date.iterator.tools.util.Other;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(final T[] array){
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for(int j = i ; j > 0 ; j --)
                if(array[j].compareTo( array[j-1] ) < 0)
                    Other.swap( array, j , j-1 );
                else
                    break;
        }
    }

    /* w-sorting */
    public static <T extends Comparable<T>> void sort(final T[] array, final int start, final int step){
        int n = array.length;
        for (int i = start; i < n; i += step) {
            for(int j = i ; j > 0 ; j --)
                if(array[j].compareTo( array[j-1] ) < 0)
                    Other.swap( array, j , j-1 );
                else
                    break;
        }
        for (int i = 0; i < step; i++) {
            for (int j = start + i; j < n - step; j += step) {
                if(array[j].compareTo( array[j + step] ) > 0)
                    Other.swap( array, j , j + step );
                else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {10,9,8,7,6,5,4,3,2,1};
        InsertionSort.sort(array);
        Other.printArray(array);
    }
}
