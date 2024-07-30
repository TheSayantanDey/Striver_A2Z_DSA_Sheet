package StringsMedium;

import java.util.Stack;

public class MaximumNestingDepthOfParentheses {
//    public int maxDepth(String s) {
//        Stack<Character> stack = new Stack<>();
//        int count = 0,maxCount=0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)=='('){
//                stack.add(s.charAt(i));
//                count++;
//            }
//            if(s.charAt(i)==')'){
//                stack.pop();
//                count--;
//            }
//            maxCount = Math.max(count,maxCount);
//        }
//        return maxCount;
//    }

    public int maxDepth(String s) {
        int count = 0,maxCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}