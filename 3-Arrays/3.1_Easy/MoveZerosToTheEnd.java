import java.util.Arrays;

public class MoveZerosToTheEnd {

    //O(n^2) time complexity
//    public static void moveZeros(int[] nums) {
//        for(int index=0;index<nums.length;index++){
//            if(nums[index]==0){
//                int secondIndex = index+1;
//                for(;secondIndex<nums.length;secondIndex++){
//                    if(nums[secondIndex] != 0){
//                        int temp = nums[index];
//                        nums[index] = nums[secondIndex];
//                        nums[secondIndex] = temp;
//                        break;
//                    }
//                }
//            }
//        }
//    }

    static void moveZeros(int[] nums){
        int index=0;
        while(nums[index] != 0){
            index++;
            if(index == nums.length){
                return;
            }
        }
        int secondIndex = index+1;
        while(secondIndex<nums.length){
            if(nums[secondIndex]!=0){
                int temp = nums[index];
                nums[index] = nums[secondIndex];
                nums[secondIndex] = temp;
                index++;
            }
            secondIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,0,0,4,0,3,0};
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

}
