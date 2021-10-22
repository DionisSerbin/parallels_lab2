package bmstu;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightComparable implements WritableComparable {

    int airportId;
    float delayTime;
    float airTime;
    boolean cancelled;

    public FlightComparable(int airportId, float delayTime, float airTime, boolean cancelled){
        this.airportId = airportId;
        this.delayTime = delayTime;
        this.airTime = airTime;
        this.cancelled = cancelled;
    }

    public FlightComparable(){}

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeInt(airportId);
        d.writeFloat(delayTime);
        d.writeFloat(airTime);
        d.writeBoolean(cancelled);
    }

    @Override
    public void readFields(DataInput d) throws IOException {
        airportId = d.readInt();
        delayTime = d.readFloat();
        airTime = d.readFloat();
        cancelled = d.readBoolean();
    }


    @Override
    public int compareTo(Object o) {
        FlightComparable a = (FlightComparable) o;
        if((this.cancelled && !a.cancelled)
                || (this.delayTime > a.delayTime)
                || (this.airportId > a.airportId)
                || (this.airTime > a.airTime)){
            return 1;
        } else  if((!this.cancelled && a.cancelled)
                || (this.delayTime < a.delayTime)
                || (this.airportId < a.airportId)
                || (this.airTime < a.airTime)){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return ("bmstu.FlightComparable{" + "airportId=" + airportId + ", delayTime="
                + delayTime + ", airTime=" + airTime + ", cancelled=" + cancelled) + "}";
    }

    public int delayCompare(Object o){
        FlightComparable a = (FlightComparable) o;
        if(this.delayTime > a.delayTime) {
            return 1;
        } else if(this.delayTime < a.delayTime){
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        FlightComparable a = (FlightComparable) obj;
        if(cancelled != a.cancelled
                || Float.compare(a.airTime, delayTime) != 0
                || Float.compare(a.delayTime, delayTime) != 0){
            return false;
        }
        return airportId == a.airportId;
    }
}