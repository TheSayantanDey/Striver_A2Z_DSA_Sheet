package SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class checkForSubsequenceForSumK {
    public static boolean isPresent(int[] arr,int index,int sum,int currentSum){
        if(index>=arr.length) return sum==currentSum;

        currentSum+=arr[index];
        if(isPresent(arr,index+1,sum,currentSum)) return true;
        currentSum-=arr[index];

        if(isPresent(arr,index+1,sum,currentSum)) return true;

        return false;

    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return isPresent(a,0,k,0);
    }
}

