import java.util.*;

public class Sort012s {

    //0(2N) solution
//    public static void sortColors(int[] arr) {
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == 0)
//                count0++;
//            else if(arr[i] == 1)
//                count1++;
//            else if(arr[i] == 2)
//                count2++;
//        }
//        int k=0;
//        while (k<count0)
//            arr[k++] =0;
//        while (k<count0+count1)
//            arr[k++] = 1;
//        while (k<arr.length)
//            arr[k++] = 2;
//    }


    //Dutch National flag Algorithm
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }else if(arr[mid] == 1){
                mid++;
            }else if(arr[mid] == 2){
                swap(arr,mid,high);
                high--;
            }
        }
    }

    //DNF on Arraylist
    public static void sortArray(ArrayList<Integer> arr, int n) {
        // Write your code here.
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid<=high){
            if(arr.get(mid)==0){
                int temp = arr.get(mid);
                arr.set(mid,arr.get(low));
                arr.set(low,temp);
                mid++;
                low++;
            }else if(arr.get(mid) == 1){
                mid++;
            }else if(arr.get(mid) == 2){
                int temp = arr.get(mid);
                arr.set(mid,arr.get(high));
                arr.set(high,temp);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
