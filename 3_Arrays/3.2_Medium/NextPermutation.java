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
    public static void marge(int[] arr,int start,int mid,int end){
        int[] temp = new int[end+1];
        int i=start;
        int j=mid+1;
        int k=start;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=end){
            temp[k++] = arr[j++];
        }

        for(int a=start;a<=end;a++){
            arr[a] = temp[a];
        }
        return;
    }
    public static void margesort(int[] arr, int start, int end){
        if(start == end){
            return;
        }
        int mid= (start+end)/2;
        margesort(arr,start,mid);
        margesort(arr,mid+1,end);
        marge(arr,start,mid,end);
    }
    public static void nextPermutation(int[] nums) {
        int targetIndex = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<nums[i+1]){
                targetIndex = i;
            }
        }
//        margesort(nums,targetIndex+1,nums.length-1);
        reverse(nums,targetIndex+1,nums.length-1); //Will do the same thing as it is in reverse sorted

        if(targetIndex == -1){
            return;
        }
        int targetIndex2 = targetIndex+1;
        while(nums[targetIndex2]<=nums[targetIndex]){
            targetIndex2++;
        }
        swap(nums,targetIndex,targetIndex2);
        return;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
