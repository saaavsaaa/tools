package date.iterator.tools.ip;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class IPTreeTest {
    @Test
    public void testSearch() throws IOException, InterruptedException {
        IPTree ipTree = new IPTree();
        ipTree.appendIP("101.1.0.0", 22 , "内蒙古-呼和浩特市-电信");
        ipTree.appendIP("101.104.144.0", 22 , "辽宁省-沈阳市-鹏博士");
        ipTree.appendIP("101.129.0.0", 16 , "北京-北京市-联通");
        ipTree.appendIP("101.198.178.0", 23 , "上海-上海市-电信");
        ipTree.appendIP("170.106.164.0", 23 , "海外-其他-其他");
        ipTree.appendIP("210.32.0.0", 12 , "浙江省-杭州市-教育网");
        ipTree.appendIP("211.139.193.0", 24 , "广东省-东莞市-移动");
        String expect = "广东省-东莞市-移动";
        String actual = ipTree.search("211.139.193.20");
        assert expect.equals(actual);
    }

    @Test
    public void debugSearch() throws IOException, InterruptedException {
        List<String> cmds = new LinkedList<String>();
        cmds.add("sh");
        cmds.add("-c");
        cmds.add("");
        String command = "sh -c cat /home/aaa/Downloads/ips | awk  -F ' ' '{print $1}'";
        IPTree ipTree = exec(command);
        System.out.println(ipTree.search("211.139.193.20"));
    }

    @Test
    public void debugConvertIP() {
        String ip = "211.139.193.20";
        String actual = IPUtil.ip2binaryString(ip);

        System.out.println(actual);

        int[] bits = IPUtil.ip2binary(ip);
        for (int i = 0; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
        System.out.println();
        ip = "211.139.193.0";
        System.out.println(IPUtil.ip2binaryString(ip));
    }

    public static IPTree exec(final String command) throws IOException, InterruptedException {
        IPTree ipTree = new IPTree();

        String output = null;
        Process process = null;
        BufferedReader br = null;
        try {
            List<String> cmds = new LinkedList<String>();
            cmds.add("sh");
            cmds.add("-c");
            cmds.add("cat /home/aaa/Downloads/ips | awk  -F ' ' '{print $1,$5}'");
            ProcessBuilder pb = new ProcessBuilder(cmds);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            //while (p.waitFor(100, TimeUnit.MILLISECONDS));
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                output += line + System.getProperty("line.separator");
                String ip = line.split(" ")[0];
                String key = line.split(" ")[1];
                ipTree.appendIP(ip.split("/")[0], Integer.parseInt(ip.split("/")[1]), key);
            }
//            IPUtil.traversalLevel(ipTree.getRoot());
        } finally {
            if (br != null) {
                br.close();
            }
            if (process != null) {
                process.destroy();
            }
        }
        // System.out.println(output);
        return ipTree;
    }

    @Test
    public void testToBinary() {
        // byte[] bytes = InetAddress.getByName("10.0.2.15").getAddress();
        //101.32.104.0 0110 0101 0010 0000 0110 1000 00000000   21
        //101.32.96.0  0110 0101 0010 0000 0110 0000 00000000   20
        String expect = "1100101001000000110100000000000"; // 11011100101101010010011010010110
        String ip = "101.32.96.0"; // "220.181.38.150"
        long start = System.currentTimeMillis();
        String actual = IPUtil.ip2binaryString(ip);
        System.out.println(actual);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        int[] bits = IPUtil.ip2binary(ip);
        for (int i = 0; i < bits.length; i++) {
            System.out.printf(String.valueOf(bits[i]));
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - start);
        assert expect.equals(actual);
    }
}
