package date.iterator.tools;

import javafx.util.Pair;
import org.junit.Assert;

import java.util.*;

public class PairCheck {
    private final Stack<Character> stack = new Stack<>();

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

    public void checkTags(final String input) {
        String currentTag = "";
        for (char c : input.toCharArray()) {
            if (c == '>') {
                currentTag += stack.pop();
                continue;
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
