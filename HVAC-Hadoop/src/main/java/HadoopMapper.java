import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.List;



public class HadoopMapper extends Mapper<LongWritable,Text,IntWritable,Text> {

    private Splitter splitter;
    private Joiner joiner;

    @Override//setup is called only once
    protected void setup(Context context) throws IOException, InterruptedException {
        splitter = Splitter.on(",").trimResults();
        joiner = Joiner.on(",");
    }

    @Override//map is called on each row
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        List<String> values = Lists.newArrayList(splitter.split(value.toString()));
        String buildingId = values.get(0);//assigning value 0 to building id and removing from list of value
        values.remove(0);
        String remainedValue = joiner.join(values);
        context.write(new IntWritable(Integer.parseInt(buildingId)),new Text(remainedValue));

    //removing the building id and sending it as key to reducer and remaining value as values
    }


}
