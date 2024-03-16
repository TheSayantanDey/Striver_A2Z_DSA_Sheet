public class MissingAndRepeatingNum {
    public static int[] findMissingRepeatingNumbers(int []a) {

        //My approach
        // int missing = -1, twice = -1, flag = 0;
        // Arrays.sort(a);
        // for (int i = 0; i < a.length-1; i++) {
        //     if(a[i+1] == a[i]){
        //         twice = a[i];
        //     }else if(a[i+1] == a[i]+2){
        //         missing = a[i]+1;
        //         flag = 1;
        //     }
        // }
        // if(flag == 0){
        //     missing = a.length;
        // }
        // int[] ans = {twice,missing};
        // return ans;


        //Optimal approach 1 uses math

//        long n = a.length;
//        //Find sum of first n numbers and sum of square of first n numbers
//        long sumN = (n*(n+1)) / 2;
//        long sumN2 = (n*(n+1)*(2*n + 1)) / 6;
//
//        //Find the sum of array elements and square of array elements
//        long sum = 0;
//        long sum2 = 0;
//        for (int i = 0; i < a.length; i++) {
//            sum += a[i];
//            sum2 += (long)a[i] * (long)a[i];
//        }
//
//        //Suppose x is the repeating element
//        //Suppose y is the missing element
//        // sum - sumN = x - y = val1
//        long val1 = sum - sumN;
//        //sum2 - sumN2 = x^2 - y^2 = val2
//        long val2 = sum2 - sumN2;
//
//        // val2/val1 = (x^2 - y^2)/(x-y) = (x+y) =  val3
//        long val3 = val2/val1;
//
//        //val3 + val1 = (x+y) + (x-y) = 2x;
//        // x = (val3+val1)/2
//        long x = (val3+val1)/2;
//
//        // val3 - x = (x+y) - x = y
//        long y = val3 - x;
//
//        return new int[]{(int)x,(int)y};


        //Optimal Approach 2 (XOR)

        //Step 1 is to XOR all array elements and first n natural number, which is (x^y)
        int xorval = 0;
        for (int i = 0; i < a.length; i++) {
            xorval ^= a[i];
            xorval ^= (i+1);
        }

        //Step 2 is to find the first 1 bit from the right of x^y 's value
        int bitNo = 0;
        while(true){
            if(((1<<bitNo) & xorval ) != 0){
                break;
            }
            bitNo++;
        }

        // Divide and Xor element into 1 part and 0 part
        int zero = 0;
        int one = 0;
        for (int i = 0; i < a.length; i++) {
            //part of 1 group:
            if ((a[i] & (1<<bitNo)) != 0) {
                one = one ^ a[i];
            }
            //part of 0 group:
            else {
                zero = zero ^ a[i];
            }
        }

        for (int i = 1; i <= a.length; i++) {
            //part of 1 group:
            if ((i & (1<<bitNo)) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }
}
