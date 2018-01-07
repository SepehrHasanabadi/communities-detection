package graph;

import hadoop.GMapper;
import hadoop.GReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by sepehr on 10/5/17.
 */
public class Main {

//    private static graph.GraphLogic graphLogic = new graph.GraphLogic();
//    public static void main(String... args) {
//        try {
//            int[][] matrix = graph.GraphView.getMatrixFromFile();
//            graph.GraphView.writeOutputToFile(matrix.length, graphLogic.splitGraph(graphLogic.getFinalGraph(matrix), 2));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void main(String[] args) throws Exception {
//
//        try {
//            int[][] matrix = graph.GraphView.getMatrixFromFile();
//            Graph graph = new Graph(12, matrix);
//            GraphView.writeOutputToFile(matrix.length, graph);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "graph clustering");
        job.setJarByClass(Main.class);
        job.setMapperClass(GMapper.class);
        job.setCombinerClass(GReducer.class);
        job.setReducerClass(GReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
