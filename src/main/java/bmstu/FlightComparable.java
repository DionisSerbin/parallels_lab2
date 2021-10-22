package bmstu;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightComparable implements WritableComparable {

    int airportId;
    double delayTime;
    double airTime;
    boolean cancelled;

    public FlightComparable(int airportId, double delayTime, double airTime, boolean cancelled){
        this.airportId = airportId;
        this.delayTime = delayTime;
        this.airTime = airTime;
        this.cancelled = cancelled;
    }

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeInt(airportId);
        d.writeDouble(delayTime);
        d.writeDouble(airTime);
        d.writeBoolean(cancelled);
    }

    @Override
    public void readFields(DataInput d) throws IOException {
        airportId = d.readInt();
        delayTime = d.readDouble();
        airTime = d.readDouble();
        cancelled = d.readBoolean();
    }


    @Override
    public int compareTo(Object o) {
        FlightComparable a = (FlightComparable) o;
        if((!this.cancelled && a.cancelled)
                || (this.delayTime > a.delayTime)
                || (this.airportId > a.airportId)
                || (this.airTime > a.airTime)){
            return 1;
        } else  if((this.cancelled && !a.cancelled)
                || (this.delayTime < a.delayTime)
                || (this.airportId < a.airportId)
                || (this.airTime < a.airTime)){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return ("bmstu.FlightComparable:" + " airportId = " + airportId + " delayTime = "
                + delayTime + " airTime = " + airTime + " cancelled = " + cancelled);
    }

    public int delayCompare(Object o){
        FlightComparable a = (FlightComparable) o;
        if(this.delayTime > a.delayTime) {
            return 1;
        }
    }
}
