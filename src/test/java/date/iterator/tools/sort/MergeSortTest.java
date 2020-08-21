package date.iterator.tools.sort;

import date.iterator.tools.Printer;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortTest(){
        // length : 9, loop : 13 ≈ 9 + log₂9 (3+)
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11};
//        input = new int[]{1, 5, 6, 2, 6, 7};
//        input = new int[]{1, 2, 6, 2, 3, 4};
        MergeSort.sort(input);
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
    }
}
