package LL;

import LL.Node;

public class FindLength {
    public int getCount(Node head) {
        // code here
        int count = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
