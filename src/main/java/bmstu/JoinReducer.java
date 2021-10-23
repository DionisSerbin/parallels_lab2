package bmstu;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class FlightReducer extends Reducer<AirWritableComparable, Text, String, Text> {

    @Override
    protected void reduce(AirWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for(Text t : values){
            context.write("Flight[key]: = [" + key.toString() + "]",
                     new Text("Flight_information[values] = [" + t.toString() + "]"));
        }
    }
}