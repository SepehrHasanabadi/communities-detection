package graph;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by sepehr on 10/6/17.
 */
public class GraphView {

    public static void main(String[] args) throws Exception {
        clusterViewGraph();
    }

    public static void clusterViewGraph()
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("part-r-00000.txt"));
        PrintWriter writer;
        writer = new PrintWriter("output.txt", "UTF-8");

        String line;
        while ((line = reader.readLine()) != null) {
            if (Integer.parseInt(line.split("\t")[1]) < 1000) {
                writer.println(line);
            }
        }
        reader.close();
        writer.close();
    }

}
