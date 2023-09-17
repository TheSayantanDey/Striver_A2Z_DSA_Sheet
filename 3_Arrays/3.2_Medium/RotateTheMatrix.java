import java.util.Arrays;

public class RotateTheMatrix {

    public static void reverse(int[] arr){
        int start = 0, end = arr.length-1;
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[][] matrix) {


        //Optimal done by me
//        //Reverse every column,filp the matrix wrt a horizontal line goes through the middle
//        int rowNum = matrix.length;
//        for (int i = 0; i < rowNum/2; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                //Swap values of matrix[i][j] with matrix[rowNum - i][j]
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[rowNum -1 - i][j];
//                matrix[rowNum -1 -i][j] = temp;
//            }
//        }
//
//        //Now rotate the matrix by 180degrees(Transpose) for the final output
//        for (int i = 0; i < rowNum; i++) {
//            for (int j = matrix[i].length-1; j >= 0 ; j--) {
//                if(i==j)
//                    break;
//                //Swap value of matrix[i][j] with matrix[j][i]
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }

        //Optimal by Striver
        //first rotate the matrix by 180degrees(Transpose) for the final output
        int rowNum = matrix.length;
        for (int i = 0; i < rowNum; i++) {
            for (int j = matrix[i].length-1; j >= 0 ; j--) {
                if(i==j)
                    break;
                //Swap value of matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse every row array
        for (int i = 0; i < rowNum; i++) {
            reverse(matrix[i]);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
