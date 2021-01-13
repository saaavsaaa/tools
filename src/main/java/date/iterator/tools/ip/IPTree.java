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
            // 0 left 1 right
            BitNode child = current.getChildren()[bits[i]];
            if (child == null) {
                child = new BitNode(value);
                current.getChildren()[bits[i]] = child;
            }
            current = child;
        }
        current.setKey(key);
        current.setIp(ip);
    }

}
