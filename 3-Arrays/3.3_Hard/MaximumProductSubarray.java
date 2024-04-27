import java.util.ArrayList;
import java.util.Map;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int prefix =1 ;
        int suffix =1;
        for (int i = 0; i < nums.length; i++) {
            if(prefix == 0) prefix =1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[nums.length-i-1];
            ans = Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {-2,0,-1};
        System.out.println(maxProduct(arr));
    }
}
