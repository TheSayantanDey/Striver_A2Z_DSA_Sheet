package BinarySearchOn1DArray;

public class SearchInRotatedArrayII {
    public boolean search(int[] nums, int target) {
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return true;
            }

            //Only modification here
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                if(nums[low]==target){
                    return true;
                }
                low++;
                high--;
            }
            else if(nums[mid]>=nums[low]){
                //Left half is sorted
                if(nums[low]<=target && target<=nums[mid]){
                    //Target is on the left sorted half.
                    high = mid-1;
                }else{
                    //Target is on the right half
                    low = mid+1;
                }
            }else{
                //right half is sorted
                if(nums[mid]<=target && target<=nums[high]){
                    //Target is on the sorted right half
                    low = mid+1;
                }else{
                    //Target is on the left half
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
