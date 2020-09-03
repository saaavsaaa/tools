package date.iterator.tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ConvertsTest {
    @Test
    public void testRadix() {
        int toRadix = 2;
        int excepted = 100;
        Stack<Integer> digit = Converts.radix(excepted, toRadix);
        int actual = 0;
        while (!digit.empty()) {
            int each = digit.pop();
            actual *= toRadix;
            actual += each;
            System.out.print(each);
        }
        System.out.println();
        Assert.assertEquals(excepted, actual);
    }

    @Test
    public void testLength() {
        Stack<Integer> digit = Converts.length(0xabc, 16);
        System.out.println("length : " + digit.size());
        while (!digit.empty()) {
            System.out.println(digit.pop());
        }
    }
}
