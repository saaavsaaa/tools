package date.iterator.tools.sort;

import date.iterator.tools.Printer;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void test(){
        Integer[] input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
//        input = new Integer[]{1, 5, 6, 2, 6, 7};
//        input = new Integer[]{1, 2, 6, 2, 3, 4};
        QuickSort<Integer> sort = new QuickSort<>(input);
        sort.sort();
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
    }
}
