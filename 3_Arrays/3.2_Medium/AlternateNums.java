import java.util.Arrays;

public class AlternateNums {
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
//    public static int[] rearrangeArray(int[] nums) {
//        int[] ans = new int[nums.length];
//        int positivePointer=0,negativePointer=0;
//        for (int i = 0; i < nums.length; i++) {
//            if(i%2==0){
//                //ith index is for a positive num
//                while(nums[positivePointer]<0){
//                    positivePointer++;
//                }
//                ans[i] = nums[positivePointer++];
//            }else{
//                //ith index is for a negative num
//                while(nums[negativePointer]>0){
//                    negativePointer++;
//                }
//                ans[i] = nums[negativePointer++];
//            }
//        }
//        return ans;
//    }


    //Another approach
    public static int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int positivePointer=0,negativePointer=1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                ans[positivePointer] = nums[i];
                positivePointer += 2;
            }else{
                ans[negativePointer] = nums[i];
                negativePointer += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,-1,-2,-3,-4};
        int[] arr2 = rearrangeArray(arr);
        System.out.println(Arrays.toString(arr2));
    }
}
