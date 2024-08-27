package LL;

import LL.Node;

public class InsertANodeAtTheEnd {
    Node insertAtEnd(Node head, int x) {
        // code here
        if(head==null){
            head = new Node(x);
            return head;
        }
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        Node xNode = new Node(x);
        temp.next = xNode;
        return head;
    }
}
