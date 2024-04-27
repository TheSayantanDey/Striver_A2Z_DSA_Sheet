import java.util.*;
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        //Brute force - Time Complexity O(N^3)
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 0; i < nums.length-2; i++) {
//            for (int j = i+1; j < nums.length-1; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    int sum = nums[i]+nums[j]+nums[k];
//                    if(sum == 0){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        Collections.sort(temp);
//                        ans.add(new ArrayList<>(temp));
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < ans.size(); i++) {
//            for (int j = i+1; j < ans.size(); j++) {
//                if(ans.get(i).equals( ans.get(j))){
//                    ans.remove(j);
//                    j--;
//                    i = ans.size();
//                }
//            }
//        }
//        return ans;


        //Better approach
//        Set<List<Integer>> tempSet = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int target = 0-nums[i];
//            HashSet<Integer> set = new HashSet<>();
//            for (int j = i+1; j < nums.length; j++) {
//                if(set.contains(target-nums[j])){
//                   List<Integer> temp = new ArrayList<>();
//                   temp.add(nums[i]);
//                   temp.add(target-nums[j]);
//                   temp.add(nums[j]);
//                   Collections.sort(temp);
//                   tempSet.add(new ArrayList<>(temp));
////                   break;
//                }
//                set.add(nums[j]);
//            }
//        }
//        List<List<Integer>> ans = new ArrayList<>(tempSet);
//        return ans;


        //Optimal Approach
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1])continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                   List<Integer> temp = new ArrayList<>(List.of(nums[i],nums[j],nums[k]));
                   ans.add(new ArrayList<>(temp));
                   j++;
                   while(j<k && nums[j]==nums[j-1])j++;
                   k--;
                   while (j<k && nums[k]==nums[k+1])k--;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-18, -1, -44, -48, -9, -16 ,-36, -13, 29, 17, -12, 9, -49 };
        List<List<Integer>> ans = threeSum(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
