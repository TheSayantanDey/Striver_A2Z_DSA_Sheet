package BinarySearchOn1DArray;

public class LowerBound {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int ans = n;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }else if(arr[mid]<x){
                low = mid+1;
            }
        }
        return ans;
    }
}
