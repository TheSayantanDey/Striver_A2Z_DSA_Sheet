package BinarySearchOn2DArray;

import java.util.ArrayList;

public class FindRowWithMax1s {
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        //	  Write your code here.
        //	  Write your code here.
        int ans = -1;
        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int flag = 0;
            for(int i=0;i<n;i++){
                if(matrix.get(i).get(mid)==1){
                    ans = i;
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) high = mid-1;
            else low = mid+1;
        }
        return ans;
    }
}
