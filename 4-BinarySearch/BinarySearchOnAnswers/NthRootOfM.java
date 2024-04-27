package BinarySearchOnAnswers;

public class NthRootOfM {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 1,high = m;
        while(low<=high){
            int mid = (low+high)>>1;
            long currentVal = 1;
            for (int i = 0; i < n; i++) {
                currentVal *= (long)mid;
                if(currentVal > m) break;
            }

            if(currentVal == m)
                return mid;
            else if(currentVal < m){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(NthRoot(9,1953125));
    }
}
