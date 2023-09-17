// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
public class MajorityElement {
    public static void merge(int[] nums,int start,int mid,int end){
        int[] temp = new int[end+1];
        int i=start,j=mid+1,k=start;

        while(i<=mid && j<=end){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[k++] = nums[i++];
        }
        while(j<=end){
            temp[k++] = nums[j++];
        }

        for(int index=start;index<=end;index++){
            nums[index] = temp[index];
        }

    }
    public static void mergesort(int[] nums, int start, int end){
        if(start == end){
            return;
        }
        int mid = (start+end)/2;
        mergesort(nums,start,mid);
        mergesort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }

    //Brute force approach
//    public int majorityElement(int[] nums) {
//        mergesort(nums,0,nums.length-1);
//        return nums[nums.length/2];
//    }


    //Using Moore's Voting Algo
    public int majorityElement(int[] nums) {
        int currentElement=-1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                count = 1;
                currentElement = nums[i];
            }else if(nums[i] == currentElement){
                count++;
            }else{
                count--;
            }
        }
        return currentElement;
    }
}
