package date.iterator.tools.tree;

import java.util.*;

public class CoordinateTree<T extends CoordinateNode> {

    protected T root;
    protected boolean initialized = false;
    // X : horizontal coordinate
    protected Map<Integer, Integer> currentXInLevel = new HashMap<>();

    public void initialize() {
        initialized = true;
    }


    public void calculateCoordinate() {
        if (!initialized) {
            initialize();
        }
        root.setDepth(0);
        root.setHorizontal(recurX(root));
    }

    private int recurX(T node) {
        List<T> children = getSubordinates(node);
        if (!currentXInLevel.containsKey(node.getDepth())) {
            currentXInLevel.put(node.getDepth(), 0);
        }
        if (children.isEmpty()) {
            return 0;
        }
        int branchX = 0;
        if (children.size() == 1) {
            T child = children.get(0);
            int supperX = currentXInLevel.get(node.getDepth());
            child.setDepth(node.getDepth() + 1);
            int levelX = levelX(child.getDepth());
            int currentX = recurX(child);
            if (supperX > currentX) {
                currentX = supperX;
            }
            if (levelX > supperX) {
                currentX = levelX;
            }
            child.setHorizontal(currentX);
            currentXInLevel.put(child.getDepth(), currentX + CoordinateNode.Width);
            branchX = currentX;
        } else {
            for (T each : children) {
                each.setDepth(node.getDepth() + 1);
                int subX = recurX(each);
                int levelX = currentXInLevel.get(each.getDepth());
                branchX = Math.max(subX, levelX);
                each.setHorizontal(branchX);
                currentXInLevel.put(each.getDepth(), branchX + CoordinateNode.Width);
            }
            int begin = children.get(0).getHorizontal();
            if (branchX - begin > 0) {
                branchX = (branchX + begin)/2;
            }
        }
        return branchX;
    }

    protected List<T> getSubordinates(T node) {
        List<T> subordinates = new ArrayList<>();
        subordinates.addAll((Collection<? extends T>) node.getChildren());
        return subordinates;
    }

    private int levelX(int depth) {
        if (currentXInLevel.containsKey(depth)) {
            return currentXInLevel.get(depth);
        }
        return 0;
    }

    public void print() {
        Queue<T> nodes = new LinkedList<>();
        nodes.offer(root);
        int lastDepth = 0;
        int lastHorizontal = 0;
        StringBuffer line = new StringBuffer();
        while (!nodes.isEmpty()) {
            T currentNode = nodes.poll();
            int count = 0;
            if (currentNode.getDepth() > lastDepth) {
                lastDepth = currentNode.getDepth();
                System.out.println(line);
                line = new StringBuffer();
                count = currentNode.getHorizontal();
                lastHorizontal = count;
            } else {
                int currentNodeHorizontal = currentNode.getHorizontal();
                count = currentNodeHorizontal - lastHorizontal;
                lastHorizontal = currentNodeHorizontal;
            }
            if (count > 0) {
                line.append(String.format("%-" + count + "s", lastDepth));
            }
            line.append("*");
            nodes.addAll((Collection<? extends T>) currentNode.getChildren());
        }
    }
}
