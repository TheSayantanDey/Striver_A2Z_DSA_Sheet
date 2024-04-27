package BinarySearchOn1DArray;

import java.util.Scanner;

public class MinimumInRotatedArray {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mini = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)>>1;

            //When the array is sorted, no need to further search
            if(nums[low]<=nums[high]){
                mini = Math.min(mini,nums[low]);
                break;
            }

            //Left half is sorted
            if(nums[mid]>=nums[low]){
                mini = Math.min(mini,nums[low]);
                low = mid+1;
            }
            //right half is sorted
            else{
                mini = Math.min(mini,nums[mid]);
                high = mid-1;
            }

        }
        return mini;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(findMin(nums));
    }
}
