import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[] arr, int start, int end){
        while(start<=end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    public static void nextPermutation(int[] nums) {
//Optimal solution using Observation

        //Find the targetIndex
        int targetIndex = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<nums[i+1]){
                targetIndex = i;
            }
        }
        // Reversing/Sorting the next part after the targetIndex
        reverse(nums,targetIndex+1,nums.length-1); //Will do the same thing as it is in reverse sorted

        //Edge case, if no targetIndex found, means this is the greatest permutation
        //So return after reversing
        if(targetIndex == -1){
            return;
        }

        //Searching for the nearest greater element in the right of targetIndex
        int targetIndex2 = targetIndex+1;
        while(nums[targetIndex2]<=nums[targetIndex]){
            targetIndex2++;
        }
        //Swapping elements on targetIndex and targetIndex2 which gives final output
        swap(nums,targetIndex,targetIndex2);
        return;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
