package BinarySearchOn1DArray;

import java.util.ArrayList;

public class FirstAndLastOccurrences {
    public static int[] firstAndLastPosition(ArrayList<Integer> nums, int n, int target) {
        // Write your code here.
        int firstPosition = -1;
        int lastPosition = -1;
        int low = 0,high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums.get(mid)>target){
                high = mid-1;
            }else if(nums.get(mid)<target){
                low = mid+1;
            }else{
                firstPosition = mid;
                high = mid-1;
            }
        }

        low = 0;
        high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums.get(mid)>target){
                high = mid-1;
            }else if(nums.get(mid)<target){
                low = mid+1;
            }else{
                lastPosition = mid;
                low = mid+1;
            }
        }
        int[] ans = {firstPosition,lastPosition};
        return ans;
    }
}
