package date.iterator.tools.ip;

public class IPTree {

    private int size = 0;
    private int high = 0;

    public BitNode getRoot() {
        return root;
    }

    private BitNode root = new BitNode(false);

    public void init() {

    }

    public String search(final String ip){
        return root.searchInChildren(IPUtil.ip2binary(ip));
    }

    // During initialization,load all known network segment addresses and the keys of the corresponding data.
    public synchronized void appendIP(final String ip, final int sub, final String key) {
        if (sub > high) {
            high = sub;
        }
        size++;
        int[] bits = IPUtil.ip2binary(ip);
        BitNode current = root;

        for (int i = 0; i < sub; i++) {
            boolean value = bits[i] == 1;
            // System.out.print(bits[i]);
            // 0 left 1 right
            /*if (ip.equals("211.139.193.0")) {
                System.out.print(bits[i]);
                if (i == 12) {
                    System.out.println();
                }
            }*/

            //101.32.104.0 0110 0101 0010 0000 0110 1000 00000000   21
            //101.32.96.0  0110 0101 0010 0000 0110 0000 00000000   20
            /*if (ip.equals("101.32.104.0")) {
                System.out.print(bits[i]);
                if (i == 19) {
                    System.out.println();
                }
            }*/
            BitNode child = current.getChildren()[bits[i]];
            /*if (sub - i == 1 && child != null) {
                System.out.println(ip);
            }*/
            if (child == null) {
                child = new BitNode(value);
                current.getChildren()[bits[i]] = child;
            }
            current = child;
        }
//        if (ip.equals("211.139.193.0")) {
//            // 11010011100010111100000100010100
//            // 11010011100010111100000100000000
//            System.out.println();
//            System.out.println(IPUtil.ip2binaryString(ip));
//        }
        current.setKey(key);
        current.setIp(ip);
//        System.out.print(":" + ip);
//        System.out.println();
    }

}
