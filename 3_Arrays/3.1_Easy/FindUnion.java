//Given two sorted array A and B, return the union of this array
import java.util.*;
public class FindUnion {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        int m = a.length;
        int n = b.length;
        int i=0,j=0;

        while(i<m && j<n){
            if(a[i] < b[j]){
                if(ans.isEmpty() || a[i] != ans.get(ans.size()-1))
                    ans.add(a[i]);
                i++;
            }else{
                if(ans.isEmpty() || b[j] != ans.get(ans.size()-1))
                    ans.add(b[j]);
                j++;
            }
        }

        while(i<m){
            if(ans.isEmpty() || a[i] != ans.get(ans.size()-1))
                ans.add(a[i]);
            i++;
        }
        while(j<n){
            if(ans.isEmpty() || b[j] != ans.get(ans.size()-1))
                ans.add(b[j]);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,2,3,4,5};
        int[] arr2 = {3,4,5,5,6,7};
        List<Integer> ans = sortedArray(arr1,arr2);
        System.out.println(ans);
    }
}
