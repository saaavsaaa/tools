package date.iterator.tools.tree;

import java.util.*;

public class CoordinateTree {

    CoordinateNode root;

    private boolean initialized = false;

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
    int baseHeight = 150;

    // X : horizontal coordinate
    Map<Integer, Integer> currentXInLevel = new HashMap<>();
    private int recurX(CoordinateNode node) {
        if (!currentXInLevel.containsKey(node.getDepth())) {
            currentXInLevel.put(node.getDepth(), 0);
        }
        if (node.getChildren().isEmpty()) {
            return 0;
        }
        int branchX = 0;
        if (node.getChildren().size() == 1) {
            CoordinateNode child = node.getChildren().get(0);
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
            for (CoordinateNode each : node.getChildren()) {
                each.setDepth(node.getDepth() + 1);
                int subX = recurX(each);
                int levelX = currentXInLevel.get(each.getDepth());
                branchX = levelX;
                if (subX > levelX) {
                    branchX = subX;
                }
                each.setHorizontal(branchX);
                currentXInLevel.put(each.getDepth(), branchX + CoordinateNode.Width);
            }
            int begin = node.getChildren().get(0).getHorizontal();
            if (branchX - begin > 0) {
                branchX = (branchX + begin)/2;
            }
        }
        return branchX;
    }

    private int levelX(int depth) {
        if (currentXInLevel.containsKey(depth)) {
            return currentXInLevel.get(depth);
        }
        return 0;
    }
}
