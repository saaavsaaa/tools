package date.iterator.tools.ip;

import date.iterator.tools.util.Other;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class IPUtil {

    public static void traversalLevel(final BitNode bitNode) {
        Queue<BitNode> queue = new LinkedList<>();
        queue.offer(bitNode);
        while (!queue.isEmpty()) {
            BitNode current = queue.poll();
            if (current.getKey() != null) {
                System.out.print(current.getKey() + ":" + current.getIp() + " ");
            }
            BitNode[] children = current.getChildren();
            if (children[0] != null) {
                queue.offer(children[0]);
                System.out.print("0 ");
            }
            if (children[1] != null) {
                queue.offer(children[1]);
                System.out.print("1 ");
            }
            System.out.println();
        }
    }

    // https://github.com/openjdk-mirror/jdk7u-jdk/blob/f4d80957e89a19a29bb9f9807d2a28351ed7f7df/src/share/native/java/lang/fdlibm/src/e_pow.c
    // https://github.com/openjdk-mirror/jdk7u-jdk/blob/f4d80957e89a19a29bb9f9807d2a28351ed7f7df/src/share/native/java/lang/fdlibm/src/w_pow.c
    public static void printTree(final IPTree tree) {
//        Math.pow()
    }

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
