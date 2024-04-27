//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
//Note: XOR properties used . 1) a ^ a = 0 , 2) a ^ 0 = a
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
