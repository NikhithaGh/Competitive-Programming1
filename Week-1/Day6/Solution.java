import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class CakeThief {
    static int a[];

    public static class CakeType {

        final int weight;
        final int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    public static long maxDuffelBagValue(CakeType[] cakeTypes, int weightCapacity) {

        // calculate the maximum value that we can carry
        if(weightCapacity == 0) return 0;
        else {
            a=new int[weightCapacity+1];
            return calculate(cakeTypes,weightCapacity);
        }

    }
    public static long calculate(CakeType[] cakeTypes, int weightCapacity){
        for(int i=0;i<=weightCapacity;i++){
            for(int j=0;j<cakeTypes.length;j++){
                CakeType c=cakeTypes[j];
                if(c.weight==0 && c.value>0) throw new IllegalArgumentException("");
                int v;
                if(c.weight>i) v=0;
                else{
                    v=c.value+a[i-c.weight];
                }
                if(v>a[i]) a[i]=v;
            }
        }
        return a[weightCapacity];
    }

