package BinarySearchOn2DArray;

import java.util.Scanner;

public class MatrixMedian {
    public static int countSmallerThanEqualToMid(int[][] matrix, int val,int row){
        int low = 0;
        int high = matrix[0].length-1;
        int lastVal = -1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(matrix[row][mid]<=val){
                lastVal = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return lastVal + 1;


    }
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int ans = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <matrix.length ; i++) {
            min = Math.min(min,matrix[i][0]);
            max = Math.max(max,matrix[i][matrix[0].length-1]);
        }
        int halfNums = (m*n+1)/2;
        while (min<=max){
            int mid = (min+max)>>1;
            int count = 0;
            for (int i = 0; i < m; i++) {
                count+= countSmallerThanEqualToMid(matrix,mid,i);
            }

            if(count<halfNums){
                min = mid+1;
            }else {
                ans = mid;
                max = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int [][] matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println(findMedian(matrix,m,n));
    }
}
