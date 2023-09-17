//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
import java.util.*;
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {

        //The brute force can be by sorting and then traversing over the array to
        // find the elements that appear more than ⌊ n/3 ⌋ times.


        // A better approach would be by using a Hashmap
        //Space complexity of O(N)
//        List<Integer> ans = new ArrayList<>();
//
//        int targetLimit = nums.length/3;
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//               map.put(nums[i],map.get(nums[i])+1);
//            }else{
//                map.put(nums[i],1);
//            }
//
//            if(map.get(nums[i])==targetLimit+1){
//                ans.add(nums[i]);
//            }
//        }
//        Collections.sort(ans);
//
//        return ans;

        //Optimal
        //Space - O(1)
        List<Integer> ans = new ArrayList<>();
        int targetLength = nums.length/3;
        int count1 = 0,element1=Integer.MIN_VALUE;
        int count2 = 0,element2=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(count1 == 0 && nums[i]!=element2){
                count1++;
                element1 = nums[i];
            }else if(count2 == 0 && nums[i]!=element1){
                count2++;
                element2 = nums[i];
            }
            else if(nums[i] == element1){
                count1++;
            }
            else if(nums[i] == element2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int finalCount1 = 0,finalCount2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == element1){
                finalCount1++;
            }
            if(nums[i] == element2){
                finalCount2++;
            }
        }
        if(finalCount1 > targetLength){
            ans.add(element1);
        }
        if(finalCount2 > targetLength){
            ans.add(element2);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,1,1,1,3,3};
        List<Integer> ans = majorityElement(arr);
        System.out.println(ans);
    }
}
