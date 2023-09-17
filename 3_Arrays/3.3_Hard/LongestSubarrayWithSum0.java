import java.util.*;
public class LongestSubarrayWithSum0 {
    public static int getLongestZeroSumSubarrayLength(int []nums){
        // Write your code here.
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int totalSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            //don't put the totalSum's key if it exists already, because we need the longest sub-array length
            if(!map.containsKey(totalSum)){
                map.put(totalSum,i);
            }

            if(map.containsKey(totalSum)){
                int len = i - map.get(totalSum);
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}
