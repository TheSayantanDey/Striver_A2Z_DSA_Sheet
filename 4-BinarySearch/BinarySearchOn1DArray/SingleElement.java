package BinarySearchOn1DArray;

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[nums.length-2] != nums[nums.length-1])
            return nums[nums.length-1];


        int low = 1,high = nums.length-2; //We ignore 1st and last element
        int ans = Integer.MIN_VALUE;
        while(low<=high){
            int mid = (low+high)>>1;
            if((nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])) {
               return nums[mid];
            }


            if((mid%2 == 0 && nums[mid]==nums[mid+1]) || (mid%2 == 1 && nums[mid]==nums[mid-1])){
                //Then we are in the left half
                low = mid+1; //Eliminate the left half
            }else{
                //We are in the right half
                high = mid-1; //Eliminate the right half
            }
        }
        return ans;
    }
}
