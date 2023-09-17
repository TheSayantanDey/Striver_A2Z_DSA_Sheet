import java.util.*;

//There is an Integer Array 'A' of size 'n'
//A sequence is successive when the adjacent elements of the sequence have a diffence of 1
//You must return the length of the longest successive sequence.
//Code-studio - medium

public class LongestSuccessiveElements {
    //Good solution - O(nlogn)+O(n)
//    public static void merge(int[] arr, int start, int mid, int end){
//        int[] temp = new int[end+1];
//        int i=start;
//        int j=mid+1;
//        int k=start;
//        while(i<=mid && j<=end){
//            if(arr[i]<arr[j]){
//                temp[k++] = arr[i++];
//            }
//            else{
//                temp[k++] = arr[j++];
//            }
//        }
//        while(i<=mid){
//            temp[k++] = arr[i++];
//        }
//        while(j<=end){
//            temp[k++] = arr[j++];
//        }
//
//        for(int a=start;a<=end;a++){
//            arr[a] = temp[a];
//        }
//        return;
//    }
//    public static void mergesort(int[] arr, int start, int end){
//        if(start == end){
//            return;
//        }
//        int mid= (start+end)/2;
//        mergesort(arr,start,mid);
//        mergesort(arr,mid+1,end);
//        merge(arr,start,mid,end);
//    }
//    public static int longestSuccessiveElements(int []a) {
//        // Write your code here.
//        mergesort(a,0,a.length-1);
//        int maxCount = 0;
//        int count = 1;
//        for (int i = 0; i < a.length-1; i++) {
//            if(a[i+1]-a[i]==1){
//                count++;
//            }
//            else if(a[i+1]-a[i]>1){
//                count = 1;
//            }
//            maxCount = Math.max(count,maxCount);
//        }
//        return maxCount;
//    }

//    Optimal
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        HashSet<Integer> set = new HashSet<>();
        int maxlen = 0;
        for(int num : a){
            set.add(num);
        }
        for(int element : set){
            if(!set.contains(element-1)){
                int temp = element+1;
                int len=1;
                while(set.contains(temp)){
                    temp++;
                    len++;
                }
                maxlen = Math.max(len,maxlen);
            }
        }
        return maxlen;
    }


    public static void main(String[] args) {
        int[] arr = {15 ,6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3};
        System.out.println(longestSuccessiveElements(arr));
    }
}
