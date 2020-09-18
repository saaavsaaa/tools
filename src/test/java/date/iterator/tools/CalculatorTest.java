package date.iterator.tools;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void initTest() {
        char[] ops = new char[]{'＋','－','×','÷','^','!','(',')'};
        for (char c : ops) {
            System.out.println((int)c);
        }
        // Calculator calculator = new Calculator();
        // calculator.expression("(1+2^3!-4)*(5!-(6-(7-(89-0!))))$");
    }
}
