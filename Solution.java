import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int speedLimit = in.nextInt();
        int lightCount = in.nextInt();
        int[] distance = new int[lightCount];
        int[] duration = new int[lightCount];
        int speed;
        double metersPerSecond = 1000.0d/3600.0d;

        for (int i = 0; i < lightCount; i++) {
            distance[i] = in.nextInt();
            duration[i] = in.nextInt();
        }
        for(speed = speedLimit; speed > 0; speed--){
            boolean pass = true;
            double S = (double)speed * metersPerSecond;
            
            for(int i = 0; i < lightCount; i++){

                double TA = (double)distance[i]/S;
                double TS = TA/(double)duration[i];

                if(TS % 2 == 1)
                    pass = false;

                double PI = Math.PI * TS;
                double TP = Math.sin(PI);

                if(TP < 0.0001d && TP > 0 || TP > -0.0001d && TP < 0)
                    TP = 0;

                double signal = Math.signum(TP);

                if(signal == -1)
                    pass = false;
            }
            if(pass)
                break;
        }
        System.out.println(speed);
    }
}
