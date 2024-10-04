package SubsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Leetcode:90
Given an integer array nums that may contain duplicates, return all possible
subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetSum2 {

    //Brute force
    /*
    public static void getSubsets(int[] nums, int index, List<Integer> path, HashSet<List<Integer>> answer){
        if(index==nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        //pick
        path.add(nums[index]);
        getSubsets(nums,index+1,path,answer);
        path.remove(path.size()-1);

        //Not pick
        getSubsets(nums,index+1,path,answer);
        return;
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> answer = new HashSet<>();
        getSubsets(nums,0,new ArrayList<>(),answer);

        return new ArrayList<>(answer);
    }
     */

    public static void getSubsets(int[] nums,int index, List<Integer> ds, List<List<Integer>> answer){
        if(index==nums.length) return;

        for (int i = index;i<nums.length;i++){
            if(i==index || nums[i]!=nums[i-1]){
                ds.add(nums[i]);
                answer.add(new ArrayList<>(ds));
                getSubsets(nums,i+1,ds,answer);
                ds.remove(ds.size()-1);
            }
        }
        return;
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        getSubsets(nums,0,new ArrayList<>(),answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
