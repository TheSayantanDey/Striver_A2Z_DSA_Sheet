package BinarySearchOnAnswers;

import java.util.ArrayList;
import java.util.Collections;

public class PaintersPartion {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int ans = -1;


        int minMaxTime = Collections.max(boards);
        int maxMaxTime = boards.stream().mapToInt(Integer::intValue).sum();

        while(minMaxTime<=maxMaxTime){
            int painters = 1;
            int time = 0;
            int currentMaxTime = (minMaxTime+maxMaxTime)>>1;
            for (int i = 0; i < boards.size(); i++) {
                time += boards.get(i);
                if(time>currentMaxTime){
                    painters++;
                    time = boards.get(i);
                }
            }

            if(painters>k){
                minMaxTime = currentMaxTime+1;
            }else if(painters==k){
                ans = currentMaxTime;
                maxMaxTime = currentMaxTime-1;
            }else{
                ans = currentMaxTime;
                maxMaxTime = currentMaxTime-1;
            }
        }
        return ans;
    }
}
