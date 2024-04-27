package BinarySearchOnAnswers;

import java.util.ArrayList;
import java.util.Collections;

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        int ans = -1;
        if(m>n) return ans;


        //The minimum of max-pages a student can get is the max value in the array
        int minPages = Collections.max(arr);
        //The maximum of max-pages a student can get is the sum of all pages in the array
        int maxPages = arr.stream().mapToInt(Integer::intValue).sum();

        //We have to find out for each value of max-pages, how many student can exist.
        //The minimum point it matches our required students(m), is the answer
        while(minPages<=maxPages){
            int students = 1;
            int pages = 0;
            int currentPages = (minPages+maxPages)>>1;
            for (int i = 0; i < arr.size(); i++) {
                pages += arr.get(i);
                if(pages>currentPages){
                    students++;
                    pages = arr.get(i);
                }
            }

            if(students>m){
                minPages = currentPages+1;
            }else if(students==m){
                ans = currentPages;
                maxPages = currentPages-1;
            }else{
                ans = currentPages;
                maxPages = currentPages-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34 ,67 ,90};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int students = 2;
        System.out.println(findPages(list,list.size(),students));
    }
}
