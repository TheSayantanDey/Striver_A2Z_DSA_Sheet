package BinarySearchOnAnswers;

public class KthMissingPositive {
    public static int findKthPositive(int[] arr, int k) {
        //Brute
        //we suppose the kth missing element is k
//        int elem = k;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i]<=elem) elem++;
//            else break;
//        }
//        return elem;

        //Optimal
        int low = 0,high = arr.length-1;
        while(low<=high){
            int mid = (low+high)>>1;

            int numShouldBeInMid = mid+1;
            int missingNum = arr[mid]-numShouldBeInMid;

            if(missingNum<k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }


        return k+high+1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));
    }
}
