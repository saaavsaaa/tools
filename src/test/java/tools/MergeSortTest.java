package tools;

import date.iterator.tools.MergeSort;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortTest(){
        int[] input = new int[]{1, 3, 2, 4, 1, 6, 5};
        MergeSort.sort(input);
    }
}
