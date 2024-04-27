package BinarySearchOnAnswers;

import java.util.Collections;
import java.util.Map;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int ans = -1;

        int minSum = Integer.MIN_VALUE;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            minSum = Math.max(minSum,nums[i]);
            maxSum += nums[i];
        }

        while(minSum<=maxSum){
            int subArrays = 1;
            int sum = 0;
            int currentSum = (minSum+maxSum)>>1;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(sum>currentSum){
                    subArrays++;
                    sum = nums[i];
                }
            }

            if(subArrays>k){
                minSum = currentSum+1;
            }else if(subArrays==k){
                ans = currentSum;
                maxSum = currentSum-1;
            }else{
                ans = currentSum;
                maxSum = currentSum-1;
            }
        }
        return ans;
    }
}
