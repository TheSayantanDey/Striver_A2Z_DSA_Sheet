package SubsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {
    //Brute
//    public static void combinations(int[] candidates, int index,List<Integer> path, int currentSum,int target, HashSet<List<Integer>> answer){
//        if(currentSum == target){
//            answer.add(new ArrayList<>(path));
//            return;
//        }
//        if(currentSum>target || index>=candidates.length) return;
//
//        //case-1: Not pick anything and just move to next index
//        combinations(candidates,index+1,path,currentSum,target,answer);
//
//        //case-2: pick the element and move to next index where there is a different element present
//        currentSum += candidates[index];
//        path.add(candidates[index]);
//        combinations(candidates,index+1,path,currentSum,target,answer);
//
//        path.remove(path.size()-1);
//        currentSum -= candidates[index];
//
//        return;
//
//    }
//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        HashSet<List<Integer>> answer = new HashSet<>();
//        combinations(candidates,0,new ArrayList<>(),0,target,answer);
//        List<List<Integer>> ans = new ArrayList<>(answer);
//        return ans;
//    }


    //Optimal
    public static void combinations(int[] candidates, int index,List<Integer> path,int target, List<List<Integer>> answer){
        if(target==0){
            answer.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || index>=candidates.length) return;

        //pick each element from index to last
        //we will not pick same element for same past path
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i]>target) break; //As the array is sorted, if any elements happens to be greater than target then no need for further checking
            if (i == index || candidates[i] != candidates[i - 1]) {
                path.add(candidates[i]);
                combinations(candidates, i + 1, path, target - candidates[i], answer);
                path.remove(path.size() - 1);
            }
        }

        return;

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        combinations(candidates,0,new ArrayList<>(),target,answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }
}
