package date.iterator.tools;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

public class PairCheckTest {

    private PairCheck pair = new PairCheck();

    @Before
    public void init() {
        initChars();
        initTags();
        pair.getSlighting().add('a');
        pair.getSlighting().add('b');
    }

    public void initChars() {
        pair.getCharPairs().put(')', '(');
        pair.getCharPairs().put(']', '[');
        pair.getCharPairs().put('}', '{');
        pair.getCharPairs().put('>', '<');
    }

    public void initTags() {
        pair.getTags().add("tr");
    }

    @Test
    public void testChars() {
        pair.checkChars("{a(b)[]}", true);
//        pair.checkChars("{a(b)[]}", false);
    }

    @Test
    public void testTags() {
        pair.checkTags("<abc>wsx</abc>");
    }
}
