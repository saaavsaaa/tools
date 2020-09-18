package date.iterator.tools;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private char[][] opTable = new char[11][11];
    private Map<Integer, Character> signs = new HashMap<>();

    public Calculator() {
        initSignTable();
    }

    // ≈ ≡ ≠ ＝ ≤≥ ＜ ＞ ≮ ≯ ∷ ± ＋ － × ÷ ／ ∫ ∮ ∝ ∞ ∧ ∨ ∑ ∏ ∪ ∩ ∈ ∵ ∴ ⊥ ‖ ∠ ⌒ ≌ ∽ √ （） 【】｛｝
    public void expression(final String input) {
        System.out.println(opTable['＋']['＋']);
    }

    private void initSignTable() {
        // I 入栈,E 执行计算,D 湮灭(括号对),E 报错
        // ) 进栈就报错，所以在前面都是E
        // \0 哨兵, 1 '＋',2 '－',3 '×', 4 '÷',5 '^', 6 '!'
        signs.put(0, '\0');
        signs.put(1, '＋');
        signs.put(2, '－');
        signs.put(3, '×');
        signs.put(4, '÷');
        signs.put(5, '^');
        signs.put(6, '!');
        signs.put(7, '(');
        signs.put(8, ')');
        signs.put(9, '[');
        signs.put(10, ']');

        opTable[0][0] = 'D';
        opTable[0][8] = 'E';
        opTable[0][10] = 'E';
        opTable[0][1] = 'I';
        opTable[0][2] = 'I';
        opTable[0][3] = 'I';
        opTable[0][4] = 'I';
        opTable[0][5] = 'I';
        opTable[0][6] = 'I';
        opTable[0][7] = 'I';
        opTable[0][9] = 'I';
    }
}
