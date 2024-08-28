package Helper;
import java.lang.*;
import java.text.DecimalFormat;

//System nanotime

public class Runtime {

    //decimal format
    DecimalFormat df = new DecimalFormat("#,###");
    public long getMS(){
       //convert into milliseconds
        return System.nanoTime() ;
    }

    public long calculateMS(long start, long end){
        return end - start;
    }

    public String format(float time){
        return df.format(time);
    }





}
