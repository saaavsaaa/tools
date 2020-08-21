package date.iterator.tools.sort;

import date.iterator.tools.Printer;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void test(){
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11};
//        input = new int[]{1, 5, 6, 2, 6, 7};
//        input = new int[]{1, 2, 6, 2, 3, 4};
        MergeSort sort = new MergeSort();
        sort.sort(input);
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
    }

    @Test
    public void circulatingSortTest(){
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11, 1, 5, 6, 2, 6, 7 , 1, 2, 6, 2, 3, 4};
        MergeSort sort = new MergeSort();
        sort.circulatingSort(input);
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
        Printer.INSTANCE.printIn();
    }

    @Test
    public void recursiveSortTest(){
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11, 1, 5, 6, 2, 6, 7 , 1, 2, 6, 2, 3, 4};
        MergeSort sort = new MergeSort();
        sort.recursiveSort(input);
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
        Printer.INSTANCE.printIn();
    }

    @Test
    public void circulatingSortSpaceTest(){
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11, 1, 5, 6, 2, 6, 7 , 1, 2, 6, 2, 3, 4};
        MergeSort sort = new MergeSort();
        sort.setSaveSpace(true);
        sort.circulatingSort(input);
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
        Printer.INSTANCE.printIn();
    }

    @Test
    public void recursiveSortSpaceTest(){
        int[] input = new int[]{1, 3, 2, 4, 5, 1, 6, 5, 11, 1, 5, 6, 2, 6, 7 , 1, 2, 6, 2, 3, 4};
        MergeSort sort = new MergeSort();
        sort.setSaveSpace(true);
        sort.recursiveSort(input);
        Printer.INSTANCE.setWillPrint(true);
        Printer.INSTANCE.printArray(input);
        Printer.INSTANCE.printIn();
    }
}
