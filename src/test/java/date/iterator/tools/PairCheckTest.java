package date.iterator.tools;

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
    public void testTag() {
        try {
            pair.checkTags("<abc>wsx</abc>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTags() {
        try {
            // 两个栈分别存 tag和内容，内容用字符串
            pair.checkTags("<as>q<abc>wsx</abc>t</as>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
