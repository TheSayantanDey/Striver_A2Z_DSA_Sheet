//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
               ans[0] = map.get(target-nums[i]);
               ans[1] = i;
            }
            map.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] ans = twoSum(nums,9);
        System.out.println(Arrays.toString(ans));
    }
}
