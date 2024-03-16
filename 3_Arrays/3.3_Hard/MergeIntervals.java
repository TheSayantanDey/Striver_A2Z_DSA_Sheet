import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0])); //Sort the 2D array based on the 1st element of each sub-array
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1)<intervals[i][0]){
                List<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                ans.add(new ArrayList<>(temp));
            }
            else{
                int preVal = ans.get(ans.size()-1).get(1);
                int newVal = Math.max(preVal,intervals[i][1]);
                ans.get(ans.size()-1).add(1,newVal);
            }
        }
//        return ans;

        int[][] ansArr = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < 2; j++) {
                ansArr[i][j] = ans.get(i).get(j);
            }
        }
        return ansArr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
