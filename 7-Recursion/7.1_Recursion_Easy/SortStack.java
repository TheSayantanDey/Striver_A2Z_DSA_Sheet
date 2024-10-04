package Recursion_Easy;

import java.util.Stack;

public class SortStack {
    static void insertAtRightPos(Stack<Integer> s, int elem){
        //Base case
        if(s.isEmpty() || s.peek() < elem){
            s.push(elem);
            return;
        }
        //Recursive Call
        int top = s.pop();
        insertAtRightPos(s,elem);

        //Calculation
        s.push(top);
        return;
    }
    public static Stack<Integer> sort(Stack<Integer> s) {
        //Base case
        if(s.size() == 1) return s;

        //Recursive call
        Integer top = s.pop();
        Stack<Integer> newStack = sort(s);

        //Calculations
        //We have to insert the top at right position in newStack
        insertAtRightPos(newStack,top);
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(41);
        s.push(32);
        s.push(3);
        s.push(11);
        s.push(15);
        System.out.println(s);
        System.out.println(sort(s));
    }
}
