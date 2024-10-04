package SubsequencePattern;

public class perfectSum {
    public static int noOfSubsetWithGivenSum(int[] arr, int start, int sum, int currentSum){
        //base case
        if(start>=arr.length) {
            if(currentSum == sum) return 1;
            return 0;
        }

        if(currentSum>sum) return 0; //For this condition too, we don't need to check (For only positive elements)

        int count = 0;
        //pick
        currentSum+=arr[start];
        count+= noOfSubsetWithGivenSum(arr,start+1,sum,currentSum);
        currentSum-=arr[start];

        //not pick
        count+= noOfSubsetWithGivenSum(arr,start+1,sum,currentSum);

        return count;
    }
    public static int perfectSum(int arr[],int n, int sum)
    {
        return noOfSubsetWithGivenSum(arr,0,sum,0);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 10, 6, 8};
        System.out.println(perfectSum(arr,6,10));
    }
}
