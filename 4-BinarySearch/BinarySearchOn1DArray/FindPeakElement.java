package BinarySearchOn1DArray;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;

        int low = 1,high = nums.length-2; //We ignore 1st and last element
        while(low<=high){
            int mid = (low+high)>>1;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                return mid;
            }

            if(nums[mid-1]<nums[mid]){ // We are on the left side of peak
                low = mid+1;
            }else{ //We are on the right side of the peak
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,1};
        System.out.println(findPeakElement(nums));
    }

}
