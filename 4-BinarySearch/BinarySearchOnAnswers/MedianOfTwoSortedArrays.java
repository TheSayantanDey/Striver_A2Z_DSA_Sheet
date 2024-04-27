package BinarySearchOnAnswers;

public class MedianOfTwoSortedArrays {
    public static int findElement(int[] nums1, int[] nums2, int k){
        int i = 0 , j= 0;
        int num = Integer.MIN_VALUE;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                num = nums1[i];
                i++;
            }else{
                num = nums2[j];
                j++;
            }
            k--;
            if(k==0){
                return num;
            }
        }
        while(i<nums1.length){
            num = nums1[i];
            i++;
            k--;
            if(k==0) return num;
        }
        while(j<nums2.length){
            num = nums2[j];
            j++;
            k--;
            if(k==0) return num;
        }
        return num;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //My approach --->  time = O(m+n) , space = O(1)
//        double ans = Integer.MIN_VALUE;
//        int totalElem = nums1.length + nums2.length;
//
//        if(totalElem%2 == 0){
//            int pos1 = totalElem/2;
//            int pos2 = (totalElem/2)+1;
//            int elem1 = findElement(nums1,nums2,pos1);
//            int elem2 = findElement(nums1,nums2,pos2);
//            ans =  ((double)elem1 + (double)elem2) /2;
//        }else{
//            int pos = (totalElem/2)+1;
//            ans = (double) findElement(nums1,nums2,pos);
//        }
//        return ans;

        double ans = Integer.MIN_VALUE;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1); //Swapping arrays so first one is smaller

        int low = 0;
        int high = n1;
        int elementsInLeftHalf = (n1+n2+1)/2;

        while(low<=high){
            int x = (low+high)/2;
            int l1,l2,r1,r2;

            if(x-1 < 0) l1 = Integer.MIN_VALUE;
            else l1 = nums1[x-1]; //x=2, nums[2-1] = nums[1]

            if((elementsInLeftHalf-x)-1 < 0) l2 = Integer.MIN_VALUE;
            else l2 = nums2[(elementsInLeftHalf-x)-1];

            if(x>=n1) r1 = Integer.MAX_VALUE;
            else r1 = nums1[x];

            if(elementsInLeftHalf-x >= n2) r2 = Integer.MAX_VALUE;
            else r2 = nums2[elementsInLeftHalf-x];

            if(l2>r1){
                low = x+1;
            }else if(l1>r2){
                high = x-1;
            }else{
                //Search end
               if((n1+n2)%2 == 0) ans = (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
               else ans = Math.max(l1,l2);
               break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums1 = {76,94,100};
        int [] nums2 = {5,5,9,11,31,36,68,71,75,100};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
