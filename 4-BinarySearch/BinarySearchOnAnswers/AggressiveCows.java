package BinarySearchOnAnswers;

import java.util.ArrayList;
import java.util.Collections;

public class AggressiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        // First Sort the stalls
        ArrayList<Integer> stallsCopy = new ArrayList<>();
        for (int i = 0; i < stalls.length; i++) {
            stallsCopy.add(stalls[i]);
        }
        Collections.sort(stallsCopy);
        for (int i = 0; i < stallsCopy.size(); i++) {
            stalls[i] = stallsCopy.get(i);
        }

        int ans = -1;
        int minDistance = 1;
        int maxDistance = stalls[stalls.length-1];
        //The search Space is between minDistance and maxDistance
        while(minDistance<=maxDistance){
            int currentDistance = (minDistance+maxDistance)>>1;
            int cows = 1;
            int lastCowAt = stalls[0];
            for (int i = 1; i < stalls.length; i++) {
                if((stalls[i]-lastCowAt)>=currentDistance){
                    cows++;
                    lastCowAt=stalls[i];
                }
            }
            if(cows<k){
                maxDistance = currentDistance-1;
            }else{
                ans = currentDistance;
                minDistance = currentDistance+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] stalls = {1,2,3};
        int cows = 2;
        System.out.println(aggressiveCows(stalls,cows));
    }
}
