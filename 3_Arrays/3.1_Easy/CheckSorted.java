public class CheckSorted {
    //Return 0/1 for false/true
    public static int isSorted(int n, int []a) {
        // Write your code here.
        if(n==0 || n==1){
            return 1;
        }
        for(int i=1;i<n;i++){
            if(a[i-1] > a[i]){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,6};
        System.out.println(isSorted(6,arr));
    }
}
