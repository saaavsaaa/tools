package date.iterator.tools.ip;

import date.iterator.tools.util.Other;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class IPUtil {

    public static String ip2binaryString(final String ip) {
        return Arrays.stream(ip.split("\\."))
                //.map(s -> String.format("%8s", new BigInteger(s).toString(2)).replaceAll(" ", "0"))
                .map(s -> Other.alignHead(Integer.toBinaryString(Integer.valueOf(s)), 8, '0'))
                .collect(Collectors.joining());
    }

    public static int[] ip2binary(final String ip) {
        int[] bits = new int[32];
        int index = 0;
        for (String each : ip.split("\\.")) {
            char[] binary = Other.alignHead(Integer.toBinaryString(Integer.valueOf(each)), 8, '0').toCharArray();
            for (int i = 0; i < binary.length; i++) {
                bits[index] = Integer.parseInt(String.valueOf(binary[i]));
                index++;
            }
        }
        return bits;
    }

    public static Iterator<String> ip2binaryIterator(final String ip) {
        return Arrays.stream(ip.split("\\."))
                .map(s -> Other.alignHead(Integer.toBinaryString(Integer.valueOf(s)), 8, '0'))
                .iterator();
    }
}
