package date.iterator.tools;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.BASE64Decoder;

import java.io.IOException;
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

    @Test
    public void aaa() throws IOException {
        String origin = "thunder://QUFodHRwOi8vb2sucmVuenVpZGEuY29tLzE5MTEvVETXr9SwLlRDx+XO+tbQ19aw5i5tcDRaWg==";
        origin = origin.substring(10);
        System.out.println(origin);
        BASE64Decoder decoder = new BASE64Decoder();
        String content =  new String(decoder.decodeBuffer(origin),"GBK"); // "UTF-8"
        System.out.println(content);
    }
}
