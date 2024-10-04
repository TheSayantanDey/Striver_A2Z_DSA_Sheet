package SubsequencePattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.SimpleTimeZone;

public class GenerateParentheses {
    public static void recursiveParenthesis(String s, int open, int close, List<String> ans){
        //Base case
        if(close == 0){
            ans.add(s);
            return;
        }

        //Recursive Calls
        if(open != 0) recursiveParenthesis(s+"(", open-1, close, ans);
        if(open<close) recursiveParenthesis(s+")",open,close-1, ans);

        return;
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recursiveParenthesis("",n,n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
