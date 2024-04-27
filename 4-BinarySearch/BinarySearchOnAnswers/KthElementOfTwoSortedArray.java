package BinarySearchOnAnswers;

import java.util.ArrayList;

public class KthElementOfTwoSortedArray {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        int ans = Integer.MIN_VALUE;
        int n1 = n;
        int n2 = m;
        if(n1>n2) return kthElement(arr2,arr1,m,n,k); //Swapping arrays so first one is smaller

        int low = 0;
        int high = n1;
        int elementsInLeftHalf = k; // 12

        while(low<=high){
            int x = (low+high)/2; //1
            int l1,l2,r1,r2;

            if(x-1 < 0) l1 = Integer.MIN_VALUE; //x-1 == 0
            else if(x-1 >= n1) l1 = Integer.MAX_VALUE;
            else l1 = arr1.get(x-1); //l1 = arr1.get(0) = 76

            if((elementsInLeftHalf-x)-1 < 0) l2 = Integer.MIN_VALUE; //(ElementsInLeftHalf -x)-1 = (12-1)-1 == 10
            else if((elementsInLeftHalf-x)-1 >= n2) l2 = Integer.MAX_VALUE;
            else l2 = arr2.get((elementsInLeftHalf-x)-1); //12-1-1 = 10

            if(x>=n1) r1 = Integer.MAX_VALUE;
            else if(x<0) r1 = Integer.MIN_VALUE;
            else r1 = arr1.get(x);

            if(elementsInLeftHalf-x >= n2) r2 = Integer.MAX_VALUE;
            else if(elementsInLeftHalf-x < 0) r2 = Integer.MIN_VALUE;
            else r2 = arr2.get(elementsInLeftHalf-x);

            if(l2>r1){
                low = x+1;
            }else if(l1>r2){
                high = x-1;
            }else{
                //Search end
                ans = Math.max(l1,l2);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(76);
        arr1.add(94);
        arr1.add(100);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5);
        arr2.add(5);
        arr2.add(9);
        arr2.add(11);
        arr2.add(31);
        arr2.add(36);
        arr2.add(68);
        arr2.add(71);
        arr2.add(75);
        arr2.add(100);
        System.out.println(kthElement(arr1,arr2,3,10,12));
        // 5 5 9 11 31 36 68 71 75 76 94 100 100
    }
}
