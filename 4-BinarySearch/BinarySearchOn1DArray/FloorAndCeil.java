package BinarySearchOn1DArray;

import java.util.Arrays;

public class FloorAndCeil {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        // Write your code here.
        Arrays.sort(arr);

        int floor=-1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<=x){
                floor = arr[mid];
                low = mid+1;
            }else if(arr[mid]>x){
                high = mid - 1;
            }
        }
        System.out.print(floor+" ");

        int ceil=-1;
        low = 0;
        high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<x){
                low = mid+1;
            }else if(arr[mid]>=x) {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        return ceil;
    }
}
