package BinarySearchOnAnswers;

import java.util.Map;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int ans = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max,piles[i]);
        }
        int low = 1, high = max;
        while(low<=high){
            int mid = (low+high)>>1;
            long hmid = 0;
            for (int i = 0; i < piles.length; i++) {
                double val = (double) piles[i] /mid;
                hmid+= (int) Math.ceil(val);
            }

            if(hmid <= h){
                ans = mid;
                high = (mid-1);
            }
            else if(hmid>h){
                low = (mid+1);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles,h));
    }
}
