package date.iterator.tools;

import java.util.Stack;

public class Converts {

    //        BigInteger .mod
    public static Stack<Integer> radix(final int value, final int toRadix) {
        Stack<Integer> eachDigit = new Stack<>();
        int digitValue = value;
        while (digitValue >= toRadix) {
            eachDigit.push(digitValue % toRadix); //余数
            digitValue /= toRadix;
        }
        eachDigit.push(digitValue);
        return eachDigit;
    }

    public static Stack<Integer> length(final int value, final int radix) {
        Stack<Integer> eachDigit = new Stack<>();
        int digitValue = value;
        int length = 1; // 长度
        while (digitValue > radix) {
            length++;
            int current = digitValue;
            digitValue /= radix;
            eachDigit.push(current - digitValue * radix); //余数
        }
        eachDigit.push(digitValue);
        return eachDigit;
    }
}
