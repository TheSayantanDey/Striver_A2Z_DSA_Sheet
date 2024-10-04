package SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combinations(int[] candidates, int index,List<Integer> path, int currentSum,int target, List<List<Integer>> answer){
        if(currentSum == target){
            answer.add(new ArrayList<>(path));
            return;
        }
        if(currentSum>target || index>=candidates.length) return;

        //case-1: Not pick anything and just move to next index
        combinations(candidates,index+1,path,currentSum,target,answer);

        //case-2: pick the element and stay in that index
        currentSum += candidates[index];
        path.add(candidates[index]);
        combinations(candidates,index,path,currentSum,target,answer);

        path.remove(path.size()-1);
        currentSum -= candidates[index];

        return;

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        combinations(candidates,0,new ArrayList<>(),0,target,answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> allCombinations = combinationSum(candidates,target);
        System.out.println(allCombinations);
    }
}
