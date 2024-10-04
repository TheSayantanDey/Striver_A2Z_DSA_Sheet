package SubsequencePattern;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSums {
    public static void getSums(ArrayList<Integer> arr, int index,int currentSum, ArrayList<Integer> answer){
        if(index>=arr.size()){
            answer.add(currentSum);
            return;
        }
        //Not take the current element
        getSums(arr,index+1,currentSum,answer);
        //Take the current element
        getSums(arr,index+1,currentSum+arr.get(index),answer);

        return;
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> answer = new ArrayList<>();
        getSums(arr,0,0,answer);
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        System.out.println(subsetSums(arr,2));
    }
}
