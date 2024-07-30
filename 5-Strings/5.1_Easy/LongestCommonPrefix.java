package StringsEasy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        //Brute force
//        int commonLength = 0;
//        for (int i = 0; i < strs[0].length(); i++) {
//            char comparingChar = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if(strs[j].length()==i) return strs[0].substring(0,commonLength);
//                else if(strs[j].charAt(i) != comparingChar) return strs[0].substring(0,commonLength);
//            }
//            commonLength++;
//        }
//        return strs[0].substring(0,commonLength);

        //Efficient
        //Step1 : Sort the words in lexicographically ascending order
        Arrays.sort(strs);
        //Step2 : Check only for the first and last word
        int commonLength = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)) break;
            commonLength++;
        }
        return strs[0].substring(0,commonLength);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
