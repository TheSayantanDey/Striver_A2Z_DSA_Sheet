import java.util.ArrayList;
import java.util.List;

public class MissingNum {

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
    public static int binarySearch(int[] nums,int target){
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static int missingNumber(int[] nums) {
        mergesort(nums,0,nums.length-1);
        for(int i=0;i<=nums.length;i++){
            if(binarySearch(nums,i)==-1){
                return i;
            }
        }
        return -1;
    }
    public static int missingNumberOptimal(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum+nums[i];
        }
        int nTotal = (n*(n+1))/2;
        return nTotal-sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberOptimal(nums));
    }
}
