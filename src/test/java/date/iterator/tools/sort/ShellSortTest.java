package date.iterator.tools.sort;

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
}
