package StringsEasy;

import java.util.Arrays;

public class ReverseWords {
    public static String reverseWords(String s) {
//        StringBuilder ans = new StringBuilder();
//        int right = s.length()-1;
//
//        while(right>=0){
//            while(right>= 0 && s.charAt(right) == ' ') right--;
//            if(right<0) break;
//            int left = right;
//            while(left-1 >=0 && s.charAt(left-1) != ' ') left--;
//            for (int i = left; i <= right; i++) {
//                ans.append(s.charAt(i));
//            }
//            ans.append(" ");
////            System.out.println(ans);
//            right = left-1;
//        }
//
//        return ans.toString().trim();


        String[] words = s.split(" +"); // here regex is "<space>+" means there can be any number of spaces
        StringBuilder sb = new StringBuilder();
        for (int i = words.length-1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "      the sky is blue";
        System.out.println(reverseWords(s));
    }
}
