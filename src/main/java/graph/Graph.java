package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sepehr on 10/5/17.
 */
public class Graph {
    private int[][] matrix;
    private Node[] nodes;
    private List<Edge> edges;
    private Integer nodeCount;

    public Graph() {
    }

    public Graph(int rootIndex, int[][] matrix) {
        this.matrix = matrix;
        nodeCount = matrix.length;
        nodes = new Node[matrix.length];
        edges = new ArrayList<>();
        nodes[rootIndex] = new Node(rootIndex);
        nodes[rootIndex].setLevel(0);
        createGraph(rootIndex);
        labelNodes(nodes[rootIndex]);
        creditGraph(nodes[rootIndex]);

    }

    private void createGraph(int rootIndex) {
        int[] distances = Dijkstra.dijkstra(matrix, rootIndex, rootIndex);
        for (int i = 0; i < distances.length; i++) {
            nodes[i] = new Node(i);
            nodes[i].setLevel(distances[i]);
        }
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++)
                if (matrix[i][j] == 1 && nodes[j].getLevel() == nodes[i].getLevel() + 1)
                    nodes[i].addChild(nodes[j]);
        }
    }

    private void labelNodes(Node mainNode) {
        for (Node node : mainNode.getChildren()) {
            node.incrementLabel();
            labelNodes(node);
        }
    }

    private int creditGraph(Node mainNode) {
        if (mainNode.isLeaf()) {
            mainNode.setCredit(1);
            return 1;
        } else {
            int sum = 0;
            for (Node node : mainNode.getChildren()) {
                int credit = creditGraph(node) / node.getLabel();
                sum += credit;
                edges.add(new Edge(mainNode, node, credit));
            }
            mainNode.setCredit(sum + 1);
            return sum + 1;
        }
    }

    private void addEdge(Edge edge) {
        boolean find = false;
        for (Edge edge1 : edges) {
            if (edge.equal(edge1)) {
                edge1.setCredit(edge.getCredit() + edge1.getCredit());
                find = true;
            }
        }

        if (!find)
            edges.add(edge);
    }

    public void addEdgesCredit(List<Edge> edges) {
        if (this.edges == null) {
            this.edges = edges;
        } else {
            for (Edge edge : edges) {
                addEdge(edge);
            }
        }
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

}



