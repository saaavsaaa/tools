package date.iterator.tools.ip;

public class BitNode {

    // nothing to use
    private boolean value;

    private String key;

    // use to debug
    private String ip;

    //private BitNode lChild;
    //private BitNode rChild;

    public BitNode[] getChildren() {
        return children;
    }

    private final BitNode[] children = new BitNode[2];

    public String searchInChildren(final int[] ipBits) {
        // using loops instead of recursion to realize search function
        int index = 0;
        BitNode current = this;
        while (index < 32) {
            BitNode[] children = current.getChildren();
            if (current.getChildren() == null){
                return "this IP address related network not exist";
            }
            BitNode child = children[ipBits[index]];
            if (child == null){
                if (current.key != null) {
                    return current.key;
                }
                return "this IP address related information not exist";
            } else {
                current = child;
                index++;
            }
        }
        return "this IP address related information not found";
    }

    public BitNode(final boolean value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public BitNode getLeftChild() {
        return children[0];
    }

    public BitNode addLeftChild(final BitNode lChild) {
        children[0] = lChild;
        //this.lChild = lChild;
        return lChild;
    }

    public BitNode getRightChild() {
        return children[1];
    }

    public BitNode addRightChild(final BitNode rChild) {
        children[1] = rChild;
        //this.rChild = rChild;
        return rChild;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
