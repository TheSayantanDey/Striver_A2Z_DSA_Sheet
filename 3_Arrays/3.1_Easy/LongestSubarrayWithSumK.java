import java.util.* ;
import java.io.*;
public class LongestSubarrayWithSumK {

    //Brute force
//    public static int longestSubarrayWithSumK(int []a, long k) {
//        // Write your code here
//        int count = 0,finalCount=0;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == k){
//                 count = 1;
//                if(count>finalCount){
//                    finalCount = count;
//                }
//            }else{
//                int sum = a[i];
//                for (int j = i+1; j < a.length; j++) {
//                    sum = sum+a[j];
//                    if(sum == k){
//                        count = j-i+1;
//                    }else if(sum>k){
//                        if(count>finalCount){
//                            finalCount = count;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        return finalCount;
//    }

    //Better: Using hashmap (Optimal solution for both +ve and -ve numbers in array)
    public static int longestSubarrayWithSumK(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int totalSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            //don't put the totalSum's key if it exists already, because we need the longest sub-array length
            if(!map.containsKey(totalSum)){
                map.put(totalSum,i);
            }

            if(map.containsKey(totalSum-k)){
                int len = i - map.get(totalSum-k);
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }

    //Optimal : Using two pointer method (for only +ve elements present in the array)
//    public static int longestSubarrayWithSumK(int []a, long k) {
//        // Write your code here
//        int left=0, right=0;
//        int len=0,maxlen=0;
//        long sum = a[0];
//
//        while(right<a.length){
//            while(left<=right && sum>k){
//                sum -= a[left];
//                left++;
//            }
//            if(sum == k){
//                len = right-left+1;
//                maxlen = Math.max(maxlen,len);
//            }
//            right++;
//            if(right<a.length)
//                sum += a[right];
//        }
//        return maxlen;
//    }

    public static void main(String[] args) {
        int[] arr = {-50, 0, 52};
        System.out.println(longestSubarrayWithSumK(arr,2));
    }
}
