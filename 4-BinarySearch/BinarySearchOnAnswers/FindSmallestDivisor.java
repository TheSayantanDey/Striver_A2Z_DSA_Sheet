package BinarySearchOnAnswers;

public class FindSmallestDivisor {
    public static int result(int[] nums, int divisor){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            double val = (double) nums[i]/divisor;
            result += (int) Math.ceil(val);
        }
        return result;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
//        //Brute force -- Linear Search.
//        //Search space is between 1 to max(nums)
//        int minElem = 1;
//        int maxElem = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            maxElem = Math.max(maxElem,nums[i]);
//        }
//
//        for (int i = minElem; i <= maxElem; i++) {
//            if(result(nums,i) <= threshold) return i;
//        }
//        return -1;

        //Optimal -- Binary Search.
        //Search space is between 1 to max(nums)
        int ans = -1;
        int minElem = 1;
        int maxElem = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxElem = Math.max(maxElem,nums[i]);
        }

        while(minElem<=maxElem){
            int currentElem = (minElem+maxElem)>>1;
            int result = result(nums,currentElem);

            if(result<=threshold){
                ans = currentElem;
                maxElem = currentElem-1;
            }else{
                minElem = currentElem+1;
            }
        }
        return ans;
    }
}
