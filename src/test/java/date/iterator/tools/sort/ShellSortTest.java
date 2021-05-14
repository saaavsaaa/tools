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
}
