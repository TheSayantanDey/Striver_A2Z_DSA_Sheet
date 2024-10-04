package SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void getCombinations(int curr,List<Integer> path, int n,int k,List<List<Integer>> combinations){

        if(n==0){
            if(path.size() == k) combinations.add(new ArrayList<>(path));
            return;
        }
        if(n<0) return;

        for (int i=curr;i<10;i++){
            path.add(i);
            getCombinations(i+1,path,n-i,k,combinations);
            path.remove(path.size()-1);
        }
        return;
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        getCombinations(1,new ArrayList<>(),n,k,combinations);
        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(9,45));
    }
}
