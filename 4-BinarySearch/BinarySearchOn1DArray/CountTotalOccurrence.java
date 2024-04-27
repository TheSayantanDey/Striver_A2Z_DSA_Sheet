package BinarySearchOn1DArray;

public class CountTotalOccurrence {
    public static int count(int[] nums, int n, int target) {
        //Your code goes here
        int firstPosition = -1;
        int lastPosition = -1;
        int low = 0,high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>target){
                high = mid-1;
            }else if(nums[mid]<target){
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
            if(nums[mid]>target){
                high = mid-1;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                lastPosition = mid;
                low = mid+1;
            }
        }
        if(lastPosition == -1) return 0;
        else
            return (lastPosition-firstPosition+1);
    }
}
