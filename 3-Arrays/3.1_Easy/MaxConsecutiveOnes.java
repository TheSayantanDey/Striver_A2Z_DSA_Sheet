//Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0,maxCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                if(count > maxCount)
                    maxCount = count;
            }
            else{

                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
