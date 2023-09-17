import java.util.*;
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length -1;

        while (left<=right && top<=bottom) {

            //First print the top
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            //Print the right
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            //Print the bottom
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //Print the left
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,},{4,5,6},{7,8,9}};
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
        List<Integer> spiralMatrix = spiralOrder(matrix);
        System.out.println(spiralMatrix);
    }
}
