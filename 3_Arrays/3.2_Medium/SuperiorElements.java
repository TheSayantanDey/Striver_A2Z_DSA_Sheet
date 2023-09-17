//An element is called superior element if it is greater than all the elements present in its right.
//Element at the most right is always a superior element.
//Return all superior elements in an Arraylist.

import java.util.*;
public class SuperiorElements {

    //Recursive

//    public static void recurSuperiorElements(int[] a,int start,List<Integer> ans){
//        if(start == a.length){
//            return;
//        }
//        if(start == a.length-1){
//            ans.add(a[start]);
//        }
//        recurSuperiorElements(a,start+1,ans);
//        if(a[start]>ans.get(ans.size()-1)){
//            ans.add(a[start]);
//        }
//    }
//
//    public static List<Integer> superiorElements(int[] a) {
//        // Write your code here.
//        List<Integer> ans = new ArrayList<>();
//        recurSuperiorElements(a,0,ans);
//        return ans;
//    }


    public static List<Integer> superiorElements(int[] a) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        ans.add(a[a.length-1]);
        for (int i = a.length-2; i >= 0 ; i--) {
            if(a[i]>ans.get(ans.size()-1)){
                ans.add(a[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        List<Integer> ans = superiorElements(arr);
        System.out.println(ans);
    }
}
