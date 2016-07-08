import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.List;



public class HadoopReducer extends Reducer<IntWritable,Text,NullWritable,Text>{

    private Splitter splitter;
    private Joiner joiner;
    boolean flag;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        splitter = Splitter.on(",").trimResults();
        joiner = Joiner.on(",");
        flag = true;
    }

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        double sumExpected=0.0,sumActual=0.0;
        int totalCount = 0;
        String modelNumber = "";
        for(Text val:values){
            List<String> rows = Lists.newArrayList(splitter.split(val.toString()));
            sumExpected+= Double.parseDouble(rows.get(rows.size()-2));//since the expected value is at ..
            sumActual+= Double.parseDouble(rows.get(rows.size()-1)+"0");
            modelNumber = rows.get(1);
            totalCount++;
        }

        if(flag){
            context.write(null,new Text("Building Id,Model Number,Expected,Actual"));
            flag = false;
        }

        String finalOutput = String.valueOf(key)+","+ modelNumber+","+(sumExpected/totalCount)+","+(sumActual/totalCount);

        context.write(null,new Text(finalOutput));

    }
}
