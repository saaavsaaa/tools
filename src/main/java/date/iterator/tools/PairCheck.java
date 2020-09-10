package date.iterator.tools;

import javafx.util.Pair;
import org.junit.Assert;

import java.util.*;

public class PairCheck {
    private final Stack<Character> stack = new Stack<>();
    private final Stack<String> tagStack = new Stack<>();

    private Map<Character, Character> charPairs = new HashMap();

    private List<String> tags = new ArrayList<>();

    private List<Character> slighting = new ArrayList<>();

    public void checkChars(final String input, boolean ignored) {
        for (char c : input.toCharArray()) {
            if (charPairs.containsKey(c)) {
                Character actual = stack.pop();
                if (ignored) {
                    actual = ignore(actual);
                }
                Character expect = charPairs.get(c);
                Assert.assertEquals(actual, expect);
            } else {
                stack.push(c);
            }
        }
        Assert.assertTrue(stack.empty());
    }

    private Character ignore(Character c) {
        if (slighting.contains(c)) {
            c = stack.pop();
            return ignore(c);
        }
        return c;
    }

    public void checkTags(final String input) throws Exception {
        int begin = -1;
        int end = -1;
        for (char c : input.toCharArray()) {
            String currentTag = "";
            if (c == '>') {
                Character expect = charPairs.get(c);
                Character current = stack.pop();
                while (!current.equals(expect)){
                    currentTag = current + currentTag;
                    current = stack.pop();
                }
                // todo 有限状态自动机 对特定的字符序列做状态跳转
                // System.out.println(currentTag);
                if (currentTag.startsWith("/")) {
                    String tag = tagStack.pop();
                    if (currentTag.substring(1).equals(tag)) {
                        System.out.print(tag + " : ");
                        while (!stack.empty()) {
                            System.out.print(stack.pop());
                        }
                        System.out.println();
                    } else {
                        throw new Exception("tag不匹配");
                    }
                } else {
                    tagStack.push(currentTag);
                }
            } else {
                stack.push(c);
            }
        }
    }

    public Map<Character, Character> getCharPairs() {
        return charPairs;
    }

    public List<Character> getSlighting() {
        return slighting;
    }

    public List<String> getTags() {
        return tags;
    }
}
