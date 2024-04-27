import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        double gap = m+n;
        while(gap>1){
            gap = Math.ceil(gap/2);
            int left = 0;
            int right = (int)gap;
            while(right < m+n){
                if(nums1[left]>nums1[right]){
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;

                }
                left++;right++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,3,4};
        merge(a,3,b,3);
        System.out.println(Arrays.toString(a));
    }
}
