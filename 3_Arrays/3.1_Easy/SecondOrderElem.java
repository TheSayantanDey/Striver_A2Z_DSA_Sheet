import java.util.Arrays;

public class SecondOrderElem {

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end+1];
        int i=start;
        int j=mid+1;
        int k=start;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=end){
            temp[k++] = arr[j++];
        }

        for(int a=start;a<=end;a++){
            arr[a] = temp[a];
        }
        return;
    }
    public static void mergesort(int[] arr, int start, int end){
        if(start == end){
            return;
        }
        int mid= (start+end)/2;
        mergesort(arr,start,mid);
        mergesort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }


    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int largest = a[0];
        int secondLargest = Integer.MIN_VALUE;
        int smallest = a[0];
        int secondSmallest = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(largest<a[i]){
                secondLargest = largest;
                largest = a[i];
            }else if(largest != a[i] && secondLargest < a[i]){
                secondLargest = a[i];
            }
            if(smallest>a[i]){
                secondSmallest = smallest;
                smallest = a[i];
            } else if(smallest != a[i] && secondSmallest > a[i]) {
                secondSmallest = a[i];
            }
        }
        int[] ans = {secondLargest,secondSmallest};
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,1,8,3,9,4};
        int[] arr2 = getSecondOrderElements(7,arr);
        System.out.println(Arrays.toString(arr2));
    }
}
