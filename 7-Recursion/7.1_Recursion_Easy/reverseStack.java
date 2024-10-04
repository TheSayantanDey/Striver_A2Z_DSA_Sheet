package Recursion_Easy;

import java.util.Stack;

public class reverseStack {
    static void insertAtBottom(Stack<Integer> s, int elem){
//        System.out.println("insertAtBottom Called");
        //Base Case
        if(s.empty()){
            s.push(elem);
            return;
        }
        int currTop = s.pop();
        insertAtBottom(s,elem);
        s.push(currTop);
        return;
    }
    static void reverse(Stack<Integer> s)
    {
//        System.out.println("reverse() called");
        //Base Case
        if(s.size() == 1) return;

        //Recursive call
        int top = s.pop();
        reverse(s);

        //Calculations
        //We have to insert the top in the bottom most place of the stack
        insertAtBottom(s,top);
        return;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
