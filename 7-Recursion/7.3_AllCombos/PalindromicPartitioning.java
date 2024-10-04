package Recursion_Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {
    public static boolean checkPalindrome(String s,int start, int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public static void getPartitions(String s,int index,List<String> parts, List<List<String>> allPartitions){
        if(index==s.length()) {
            if(!parts.isEmpty()) allPartitions.add(new ArrayList<>(parts));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(checkPalindrome(s,index,i)){
                parts.add(s.substring(index,i+1));
                getPartitions(s,i+1,parts,allPartitions);
                parts.remove(parts.size()-1);
            }
        }
        return;
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> allPartitions = new ArrayList<>();
        getPartitions(s,0,new ArrayList<>(),allPartitions);
        return allPartitions;
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(partition(s));
    }
}
