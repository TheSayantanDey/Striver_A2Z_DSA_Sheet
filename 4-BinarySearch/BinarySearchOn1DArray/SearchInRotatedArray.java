package BinarySearchOn1DArray;

public class SearchInRotatedArray {
    public static int search(int[] nums, int target){
        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            int mid = (high + low)/2;
            if(nums[mid] == target){
                return mid;
            }

            //Left half is sorted
            if(nums[mid]>nums[low]){

                //Target is in left half
                if(target<nums[mid] && target>=nums[low]){
                    high = mid-1;
                }
                //Target is in right half
                else{
                    low = mid+1;
                }
            }
            //Right half is sorted
            else{
                //Target is in right half
                if(target>nums[mid] && target<=nums[high]){
                    low = mid+1;
                }
                //Target is in right half
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
