package graph;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by sepehr on 10/6/17.
 */
public class GraphView {

    public static int[][] getMatrixFromFile()
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("facebook.txt"));
        String line;
        boolean firstLine = true;
        int[][] matrix = null;
        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                matrix = new int[Integer.parseInt(line)][Integer.parseInt(line)];
                firstLine = false;
            }
            else {
                Integer xIndex = Integer.parseInt(line.split(" ")[0]);
                Integer yIndex = Integer.parseInt(line.split(" ")[1]);
                matrix[xIndex][yIndex] = 1;
                matrix[yIndex][xIndex] = 1;
            }
        }
        reader.close();
        return matrix;
    }

    public static void writeOutputToFile(int nodeCount, Graph graph) {
        ArrayList<Integer> ids = new ArrayList<>();
        PrintWriter writer;
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
            for (Edge edge : graph.getEdges()) {
                writer.println(edge.getFirstNode().getId() + " - " + edge.getSecondNode().getId());
                ids.add(edge.getFirstNode().getId());
                ids.add(edge.getSecondNode().getId());
            }
            for (int i = 0; i < nodeCount; i++) {
                if (!ids.contains(i)) {
                    writer.println(i);
                }
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
