import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfInversions {

    // Brute force
    public static int numberOfInversions(int []a, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(a[i]>a[j])
                    count++;
            }
        }
        return count;
    }

    //My approach

//    public static int merge(int[] arr, int start, int mid, int end){
//        int count = 0;
//        int[] temp = new int[end+1];
//        int i=start;
//        int j=mid+1;
//        int k=start;
//        while(i<=mid && j<=end){
//            if(arr[i]<=+arr[j]){
//                temp[k++] = arr[i++];
//                count += (k-i);
//            }
//            else{
//                temp[k++] = arr[j++];
//            }
//        }
//        while(i<=mid){
//            temp[k++] = arr[i++];
//            count += (k-i);
//        }
//        while(j<=end){
//            temp[k++] = arr[j++];
//        }
//
//        for(int a=start;a<=end;a++){
//            arr[a] = temp[a];
//        }
//        return count;
//    }
//    public static int numberOfInversionsOptimal(int[] arr, int start, int end){
//        if(start == end){
//            return 0;
//        }
//        int mid= (start+end)/2;
//        int a = numberOfInversionsOptimal(arr,start,mid);
//        int b = numberOfInversionsOptimal(arr,mid+1,end);
//        int c = merge(arr,start,mid,end);
//        return a+b+c;
//    }
//
//    public static int numberOfInversionsOptimal(int[] a ,int n) {
//        return numberOfInversionsOptimal(a,0,n-1);
//    }

    //Striver's approach
    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int numberOfInversionsOptimal(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {15, 28, 11, 20, 14, 7, 14, 2, 15, 4, 22, 19, 17, 1, 26, 6, 20, 2, 6 };
        System.out.println(numberOfInversionsOptimal(arr,arr.length));
        System.out.println(Arrays.toString(arr));
    }
}
