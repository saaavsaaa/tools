package date.iterator.tools;

import date.iterator.tools.tree.TagTree;
import org.junit.Assert;

import java.util.*;

public class PairCheck {
    private final Stack<Character> stack = new Stack<>();
    private final Stack<String> tagStack = new Stack<>();

    private Map<Character, Character> charPairs = new HashMap();

    private Map<String, String> tagContent = new HashMap();

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

    // todo 有限状态自动机 对特定的字符序列做状态跳转
    public void checkTags(final String input) throws Exception {
        boolean inTag = false;
        boolean changed = false;
        String content = "";
        String currentTag = "";
        for (char c : input.toCharArray()) {
            if (c == '>') {
                inTag = !inTag;
                if (currentTag.startsWith("/")) {
                    String tagHead = tagStack.pop();
                    if (currentTag.substring(1).equals(tagHead)) {
                        String currentContent = content;
                        if (tagContent.containsKey(tagHead)) {
                            currentContent += tagContent.get(tagHead);
                            tagContent.remove(tagHead);
                        }
                        System.out.print(tagHead + " : ");
                        System.out.println(currentContent);
                        currentTag = "";
                        content = "";
                    } else {
                        throw new Exception("tag不匹配");
                    }
                } else {
                    if (!tagStack.empty()) {
                        String key = tagStack.peek();
                        if (tagContent.containsKey(key)) {
                            tagContent.put(key, tagContent.get(key) + content);
                        } else {
                            tagContent.put(key, content);
                        }
                    }
                    // 标签外的暂时丢掉
                    content = "";
                    tagStack.push(currentTag);
                    currentTag = "";
                }
            } else {
                if (c == '<') {
                    inTag = !inTag;
                    continue;
                }
                if (inTag) {
                    currentTag += c;
                } else {
                    content += c;
                }
            }
        }
    }

    public void buildTagTree(final String input) throws Exception {
        TagTree tree = new TagTree();

        boolean inTag = false;
        boolean changed = false;
        String content = "";
        String currentTag = "";
        for (char c : input.toCharArray()) {
            if (c == '>') {
                inTag = !inTag;
                if (currentTag.startsWith("/")) {
                    String tagHead = tagStack.pop();
                    if (currentTag.substring(1).equals(tagHead)) {
                        String currentContent = content;
                        if (tagContent.containsKey(tagHead)) {
                            currentContent += tagContent.get(tagHead);
                            tagContent.remove(tagHead);
                        }
                        System.out.print(tagHead + " : ");
                        System.out.println(currentContent);
                        currentTag = "";
                        content = "";
                    } else {
                        throw new Exception("tag不匹配");
                    }
                } else {
                    if (!tagStack.empty()) {
                        String key = tagStack.peek();
                        if (tagContent.containsKey(key)) {
                            tagContent.put(key, tagContent.get(key) + content);
                        } else {
                            tagContent.put(key, content);
                        }
                    }
                    // 标签外的暂时丢掉
                    content = "";
                    tagStack.push(currentTag);
                    currentTag = "";
                }
            } else {
                if (c == '<') {
                    inTag = !inTag;
                    continue;
                }
                if (inTag) {
                    currentTag += c;
                } else {
                    content += c;
                }
            }
        }
    }

    // 有 bug，只能处理单个不嵌套的情况
    @Deprecated
    public void checkTag(final String input) throws Exception {
        for (char c : input.toCharArray()) {
            String currentTag = "";
            if (c == '>') {
                Character expect = charPairs.get(c);
                Character current = stack.pop();
                while (!current.equals(expect)){
                    currentTag = current + currentTag;
                    current = stack.pop();
                }

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
