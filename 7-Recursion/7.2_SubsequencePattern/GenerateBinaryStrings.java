/*
Generate all binary strings without consecutive 1’s
Given an integer, k. Generate all binary strings of length k without consecutive 1’s.

        Examples:
        Input : K = 3
        Output : 000 , 001 , 010 , 100 , 101
        Input : K  = 4
        Output :0000 0001 0010 0100 0101 1000 1001 1010

 */
package SubsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    static List<String> generateBinaryStrings(int k){
        //Base case
        if(k==1){
           List<String> list = new ArrayList<>();
           list.add("0");
           list.add("1");
           return list;
        }

        //Recursive call
        List<String> preAns = generateBinaryStrings(k-1);

        //Calculations
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < preAns.size(); i++) {
            String elem = preAns.get(i);
            ans.add(elem.concat("0"));
            if(elem.endsWith("0")) ans.add(elem.concat("1"));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(generateBinaryStrings(4));
    }
}
