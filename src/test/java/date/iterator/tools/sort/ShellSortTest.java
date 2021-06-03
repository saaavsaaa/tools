package date.iterator.tools.sort;

import date.iterator.tools.Printer;
import date.iterator.tools.util.Other;
import org.junit.Test;

public class ShellSortTest {
    @Test
    public void testSequence(){
        Other.printArray(ShellSort.ps(10));
        Other.printArray(ShellSort.sedgewick(10));
        Other.printArray(ShellSort.prime(10));
    }

    @Test
    public void test() {
        Integer[] input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
        ShellSort<Integer> shellSort = new ShellSort<>(SequenceType.prime, 10);
        shellSort.sort(input); // 9
        Other.printArray(input);

        input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
        shellSort = new ShellSort<>(SequenceType.sedgewick, 10);
        shellSort.sort(input); // 15
        Other.printArray(input);

        input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
        shellSort = new ShellSort<>(SequenceType.ps, 10);
        shellSort.sort(input); // 10
        Other.printArray(input);
    }

    @Test
    public void testReverseOrder() {
        //Integer[] input = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        Integer[] input = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        ShellSort<Integer> shellSort = new ShellSort<>(SequenceType.prime, 10);
        shellSort.sort(input); // 9
        Other.printArray(input);

        input = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        shellSort = new ShellSort<>(SequenceType.sedgewick, 10);
        shellSort.sort(input); // 15
        Other.printArray(input);

        input = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        shellSort = new ShellSort<>(SequenceType.ps, 10);
        shellSort.sort(input); // 10
        Other.printArray(input);
    }

    @Test
    public void testWithInsert() {
        Integer[] input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
        ShellSort<Integer> shellSort = new ShellSort<>(SequenceType.prime, 10);
        shellSort.sortWithInsertionSort(input);
        Other.printArray(input);
        Printer.INSTANCE.printIn("prime"); //16

        input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
        shellSort = new ShellSort<>(SequenceType.sedgewick, 10);
        shellSort.sortWithInsertionSort(input);
        Other.printArray(input);
        Printer.INSTANCE.printIn("sedgewick"); //16

        input = new Integer[]{1, 3, 6, 4, 5, 1, 2, 5, 11, 100, 9, 7};
        shellSort = new ShellSort<>(SequenceType.ps, 10);
        shellSort.sortWithInsertionSort(input);
        Other.printArray(input);
        Printer.INSTANCE.printIn("ps"); //14
    }

    @Test
    public void testReverseOrderWithInsert() {
        Integer[] input = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        ShellSort<Integer> shellSort = new ShellSort<>(SequenceType.prime, 10);
        shellSort.sortWithInsertionSort(input);
        Other.printArray(input);

        Printer.INSTANCE.printIn("prime");

        input = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        shellSort = new ShellSort<>(SequenceType.sedgewick, 10);
        shellSort.sortWithInsertionSort(input);
        Other.printArray(input);

        Printer.INSTANCE.printIn("sedgewick");

        input = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        shellSort = new ShellSort<>(SequenceType.ps, 10);
        shellSort.sortWithInsertionSort(input);
        Other.printArray(input);

        Printer.INSTANCE.printIn("ps");
    }
}
