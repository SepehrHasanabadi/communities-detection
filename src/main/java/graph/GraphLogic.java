package graph;

import java.util.Iterator;

/**
 * Created by sepehr on 10/5/17.
 */
public class GraphLogic {

    public static Graph getFinalGraph(int[][] matrix) {
        Graph mainGraph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Graph graph = new Graph(i, matrix);
            mainGraph.addEdgesCredit(graph.getEdges());
        }

        return mainGraph;
    }

    public static Graph splitGraph(Graph graph, int count) {
        if (count == 0) {
            return graph;
        }
        int max = -1;
        for (Edge edge : graph.getEdges()) {
            if (edge.getCredit() > max)
                max = edge.getCredit();
        }

        Iterator<Edge> iterator = graph.getEdges().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCredit() == max)
                iterator.remove();
        }

        return splitGraph(graph, count - 1);
    }


}
