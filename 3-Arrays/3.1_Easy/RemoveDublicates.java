public class RemoveDublicates {
    public static int removeDub(int[] nums){
        int indexPointer=0;
        int currentPointer=0;
        for(currentPointer=0;currentPointer<nums.length;currentPointer++){
            if(nums[indexPointer] != nums[currentPointer]){
                indexPointer++;
                nums[indexPointer] = nums[currentPointer];
            }
        }
        return indexPointer+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};
        int k = removeDub(arr);
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
