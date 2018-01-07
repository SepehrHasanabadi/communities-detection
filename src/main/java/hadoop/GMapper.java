package hadoop;

import graph.Edge;
import graph.Graph;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by sepehr on 1/4/18.
 */
public class GMapper extends Mapper<Object, Text, Text, IntWritable>{

    @Override
    public void map(Object key, Text value, Context context
    ) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        Integer rootNode = Integer.valueOf(itr.nextToken());
        Integer nodeCount = Integer.valueOf(itr.nextToken());
        int[][] matrix = new int[nodeCount][nodeCount];
        while (itr.hasMoreTokens()) {
            Integer xIndex = Integer.parseInt(itr.nextToken());
            Integer yIndex = Integer.parseInt(itr.nextToken());
            matrix[xIndex][yIndex] = 1;
            matrix[yIndex][xIndex] = 1;
        }
        Graph graph = new Graph(rootNode, matrix);
        for (Edge edge : graph.getEdges()) {
            context.write(new Text("edges: " + edge.getFirstNode().getId() + "<-->" + edge.getSecondNode().getId()),
                    new IntWritable(edge.getCredit()));
        }
    }
}