package bmstu;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlightPartitioner extends Partitioner<FlightComparable, Text> {

    @Override
    public int getPartition(FlightComparable flightComparable, Text text, int i) {
        int = Double.hashCode(flightComparable.delayTime) & Integer.MAX_VALUE
        return 0;
    }
}
