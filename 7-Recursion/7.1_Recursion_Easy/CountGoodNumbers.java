package Recursion_Easy;

public class CountGoodNumbers {
    private static int MOD = 1_000_000_007;
    public static int countGoodNumbers(long n) {
        long evenPos = (n+1)/2;
        long oddPos = n-evenPos;

        long evenWeight = pow(5,evenPos)%MOD;
        long oddWeight = pow(4,oddPos)%MOD;

        return (int)((evenWeight*oddWeight) % MOD);
    }

    public static long pow(int x, long n){
        if(n==0) return 1;
        long temp = pow(x, n/2);

        if(n%2 == 1) return (x*temp*temp) % MOD;
        return (temp*temp) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
}
