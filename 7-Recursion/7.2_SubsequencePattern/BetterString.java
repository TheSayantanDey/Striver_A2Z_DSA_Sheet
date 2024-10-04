package SubsequencePattern;

import java.util.HashSet;

/*
Given a pair of strings of equal lengths, Geek wants to find the better string.
The better string is the string having more number of distinct subsequences.
If both the strings have equal count of distinct subsequence then return str1.
 */
public class BetterString {
    public static void distinctSubsequence(String str, StringBuilder current, int index, HashSet<String> set){
        if(index>=str.length()){
            set.add(current.toString());
            return;
        }

        //Take
        current.append(str.charAt(index));
        distinctSubsequence(str,current,index+1,set);
        current.deleteCharAt(current.length()-1);

        //Not take
        distinctSubsequence(str, current,index+1,set);

        return;
    }
    public static String betterString(String str1, String str2) {
        HashSet<String> first = new HashSet<>();
        distinctSubsequence(str1,new StringBuilder(),0,first);
        System.out.println(first.size());
        HashSet<String> second = new HashSet<>();
        distinctSubsequence(str2,new StringBuilder(),0,second);
        System.out.println(second.size());
        if(first.size()>=second.size()) return str1;
        return str2;
    }

    public static void main(String[] args) {
        String str1 = "gboubwd";
        String str2 = "bekoilx";
        System.out.println(betterString(str1,str2));
    }
}
