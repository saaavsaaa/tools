package date.iterator.tools.util;

// import java.util.function.Consumer;

public class Other {

    public static String alignHead(final String str, final int targetLength, final char pack) {
        return alignLength(str, targetLength, true, pack);
    }

    public static String alignTail(final String str, final int targetLength, final char pack) {
        return alignLength(str, targetLength, false, pack);
    }

    private static String alignLength(final String str, final int targetLength, final boolean toHead
            , final char pack) {
        if (str.length() >= targetLength) return str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        int loop = targetLength - str.length();
        for (int i = 0; i < loop; i++) {
            if (toHead) {
                stringBuffer.insert(0, pack);
            } else {
                stringBuffer.append(pack);
            }
        }
        return stringBuffer.toString();
    }

    /*public static String alignHead(final String str, final int targetLength, final char pack) {
        StringBuffer stringBuffer = null;
        Consumer<Integer> action = (i) -> stringBuffer.insert(i, java.util.Optional.of(pack));
        return alignLength(str, targetLength, action, stringBuffer);
    }

    private static String alignLength(final String str, final int targetLength
            , final Consumer<? super Integer> action, StringBuffer stringBuffer) {
        if (str.length() >= targetLength) return str;
        stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        int loop = targetLength - str.length();
        for (int i = 0; i < loop; i++) {
            action.accept(0);
        }
        return stringBuffer.toString();
    }*/
}
