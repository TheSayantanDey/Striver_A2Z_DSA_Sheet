import java.util.Arrays;

public class RotateArray {

    //Using O(n) space complexity
//    public static void leftRotateByK(int[] arr,int k){
//        int[] ans = new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            ans[i] = arr[(i+k)%arr.length];
//        }
//        for(int i=0;i<arr.length;i++){
//            arr[i] = ans[i];
//        }
//    }
//
//    public static void rightRotateByK(int[] nums,int k){
//        //Rightshift by k
//        //from calculation by hand I got if the new array is int[] ans
//        // ans[(i+k)%nums.length] = nums[i]
//        int[] ans = new int[nums.length];
//        for(int i=0;i<nums.length;i++){
//            ans[(i+k)%nums.length] = nums[i];
//        }
//        for(int i=0;i<nums.length;i++){
//            nums[i] = ans[i];
//        }
//    }

    //Using O(1) space
    public static void reverse(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void leftRotateByK(int[] arr,int k){
        reverse(arr,0,k-1);
        reverse(arr, k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    public static void rightRotateByK(int[] arr,int k){
        reverse(arr,0,arr.length-k-1);
        reverse(arr, arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        leftRotateByK(arr,2);
        rightRotateByK(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
