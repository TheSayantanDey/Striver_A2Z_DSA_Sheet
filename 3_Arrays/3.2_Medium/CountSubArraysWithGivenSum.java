import java.util.HashMap;

public class CountSubArraysWithGivenSum {

    //Brute force - O(n^2) time
//    public static int subarraySum(int[] nums, int k) {
//        int ans=0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if(sum == k){
//                    ans++;
//                    break;
//                }
//                else if(sum>k){
//                    break;
//                }
//            }
//        }
//        return ans;
//    }


    //Optimal for both positive and negative elements present
//    public static int subarraySum(int[] nums, int k) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(0,1);
//        int totalSum = 0;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            totalSum += nums[i];
//
//            if(map.containsKey(totalSum-k)){
//                count += map.get(totalSum-k);
//            }
//
//            if(!map.containsKey(totalSum)){
//                map.put(totalSum,1);
//            }
//            else{
//                int mapValue = map.get(totalSum);
//                map.put(totalSum,mapValue+1);
//            }
//
//
//        }
//        return count;
//    }


    //Optimal for only positive elements present
    public static int subarraySum(int[] nums, int k) {
        int left=0, right=0;
        int count = 0;
        long sum = nums[0];

        while(right<nums.length){
            while(left<=right && sum>k){
                sum -= nums[left];
                left++;
            }
            if(sum == k){
                count++;
            }
            right++;
            if(right<nums.length)
                sum += nums[right];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,-1,0};
        System.out.println(subarraySum(arr,0));
    }
}
