package SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
//    public static void recurSubset(int[] nums, int start, List<List<Integer>> ans){
//        //Base Case
//        if(start == nums.length) {
//            List<Integer> emptyList = new ArrayList<>();
//            ans.add(emptyList);
//            System.out.println(emptyList);
//            return;
//        }
//
//        //Recursive call
//        recurSubset(nums, start+1, ans);
//
//        //Calculations
//        int n =  ans.size();
//        for (int i = 0; i < n; i++) {
////            List<Integer> temp = ans.get(i); // Does a shallow copy, resulting wrong ans
//            List<Integer> temp = new ArrayList<>(ans.get(i)); //Deep copy
//            temp.add(nums[start]);
//            ans.add(temp);
//        }
//        return;
//    }
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        recurSubset(nums,0,ans);
//        return ans;
//    }

    public static void recurSubset(int[] nums, List<Integer> elems,  int start, List<List<Integer>> ans){
        //Base Case
        if(start == nums.length) {
            ans.add(new ArrayList<>(elems));
            return;
        }

        //Recursive call
        elems.add(nums[start]); //Take
        recurSubset(nums,elems,start+1,ans);
        elems.remove(elems.size()-1); // Not take
        recurSubset(nums,elems,start+1,ans);
        return;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> elems = new ArrayList<>();
        recurSubset(nums,elems,0,ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> powerSet = subsets(nums);
        System.out.println(powerSet);
    }
}
