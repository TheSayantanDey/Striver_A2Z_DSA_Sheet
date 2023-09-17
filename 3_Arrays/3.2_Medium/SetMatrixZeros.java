import java.util.Arrays;

public class SetMatrixZeros {

    //Space Complexity = O(m+n)
//    public static void setZeroes(int[][] matrix) {
//        int[] targetRows = new int[matrix.length];
//        int[] targetColumns = new int[matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if(matrix[i][j]==0){
//                    targetRows[i] = 1;
//                    targetColumns[j] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if(targetRows[i] == 1 || targetColumns[j] == 1){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//        setZeroes(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//    }

    //Using O(1) space
    public static void setZeroes(int[][] matrix) {
//        int[] targetRows = new int[matrix.length];
//        int[] targetColumns = new int[matrix[0].length];
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0 && j==0){
                    col0 = 0;
                }else if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = matrix.length-1; i > 0; i--) {
            for (int j = matrix[i].length-1; j > 0 ; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0==0){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{-4,-2147483648,6,-7,0},{8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
