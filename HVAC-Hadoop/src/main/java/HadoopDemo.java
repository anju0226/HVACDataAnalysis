


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class HadoopDemo{
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        String inputFile = "input/firstResult.csv";
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);


        FileInputFormat.setInputPaths(job,inputFile);
        FileOutputFormat.setOutputPath(job,new Path("secondResult.csv"));


        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);


        job.setOutputKeyClass(IntWritable.class);//key is integer so
        job.setOutputValueClass(Text.class);//value is string so

        job.setMapperClass(HadoopMapper.class);//giving the mapper class
        job.setReducerClass(HadoopReducer.class);//setting the reducer class

        job.setJarByClass(HadoopDemo.class);//setting the main class
        job.setJobName("First Written Job");

        job.waitForCompletion(true);

        //how does it send parameters to mapper

    }
}
