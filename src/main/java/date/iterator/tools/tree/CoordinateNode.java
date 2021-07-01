package date.iterator.tools.tree;

import java.util.ArrayList;
import java.util.List;

public class CoordinateNode {
    private final String label;
    private List<CoordinateNode> children;
    private int depth = 0;
    private int horizontal = 0;

    public static final int BaseWidth = 150;
    public static final int IntervalWidth = 0;
    public static final int Width = BaseWidth + IntervalWidth;

    public CoordinateNode(String label) {
        this.label = label;
        children = new ArrayList<>();
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public String getLabel() {
        return label;
    }

    public List<CoordinateNode> getChildren() {
        return children;
    }

    public void setChildren(List<CoordinateNode> children) {
        if (children.isEmpty()) {
            return;
        }
        this.children = children;
    }

    public void addChild(CoordinateNode child) {
        this.children.add(child);
    }
}
