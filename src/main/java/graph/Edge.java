package graph;

/**
 * Created by sepehr on 10/6/17.
 */
public class Edge {
    private Node firstNode;
    private Node secondNode;
    private int credit;

    public Edge(Node firstNode, Node secondNode, int credit) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.credit = credit;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }

    public void setSecondNode(Node secondNode) {
        this.secondNode = secondNode;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean equal(Edge edge) {
        return ((edge.getFirstNode().getId() == getFirstNode().getId() && edge.getSecondNode().getId() == getSecondNode().getId()) ||
                (edge.getSecondNode().getId() == getFirstNode().getId() && edge.getFirstNode().getId() == getSecondNode().getId()));
    }
}
