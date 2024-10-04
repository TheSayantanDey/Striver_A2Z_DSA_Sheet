package Recursion_Easy;

public class powNx {
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n<0) return (1/(myPow(x,-n-1) * x));;

        double val = myPow(x,n/2);
        if(n%2 == 1) return x * val * val;
        return val*val;
    }

    public static void main(String[] args) {
        System.out.println(myPow(1.00000,-2147483648));
    }
}
