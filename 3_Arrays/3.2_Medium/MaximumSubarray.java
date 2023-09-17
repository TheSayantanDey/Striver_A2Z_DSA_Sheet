public class MaximumSubarray {
    //Brute force
//    public static int maxSubArray(int[] arr) {
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            int sum = 0;
//            maxSum = Math.max(sum,maxSum);
//            for (int j = i; j < arr.length; j++) {
//                sum += arr[j];
//                maxSum = Math.max(sum,maxSum);
//            }
//        }
//        if(maxSum<0)
//            return 0;
//        return maxSum;
//    }


    //Kadane's Algorithm: TC- 0(N)
    public static int maxSubArray(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(sum<0){
                sum = 0;
            }
            sum += arr[i];
            max = Math.max(max,sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
