package date.iterator.tools.sort;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortTest(){
        // length : 9, loop : 13 ≈ 9 + log₂9 (3+)
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11};
        MergeSort.sort(input);
    }
}
