package BinarySearchOn1DArray;

public class FindRotation {
    public static int findKRotation(int []nums){
        // Write your code here.
        int low = 0;
        int high = nums.length-1;
        int mini = Integer.MAX_VALUE;
        int minIndex = -1;
        while(low<=high){
            int mid = (low+high)>>1;

            //When the array is sorted, no need to further search
            if(nums[low]<=nums[high]){
                if(nums[low] < mini){
                    mini = nums[low];
                    minIndex = low;
                }
                break;
            }

            //Left half is sorted
            if(nums[mid]>=nums[low]){
                if(nums[low] < mini){
                    mini = nums[low];
                    minIndex = low;
                }
                low = mid+1;
            }
            //right half is sorted
            else{
                if(nums[mid] < mini){
                    mini = nums[mid];
                    minIndex = mid;
                }
                high = mid-1;
            }

        }
        return minIndex;
    }
}
