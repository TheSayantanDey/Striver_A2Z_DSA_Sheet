package StringsEasy;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                if(!stack.empty()) ans.append('(');
                stack.add('(');
            }else if(s.charAt(i) == ')'){
                stack.pop();
                if(!stack.empty()) ans.append(')');
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
}
