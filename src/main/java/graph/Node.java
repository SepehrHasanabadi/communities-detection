package graph;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sepehr on 10/5/17.
 */
public class Node {

    private int id;
    private List<Node> children;
    private Integer level;
    private Integer label = 0;
    private Integer credit = 0;

    public Node(int id) {
        this.id = id;
        children = new ArrayList<>();
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public void incrementLabel() {
        label++;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
