package HardProblemsLL;

import java.util.HashMap;
import java.util.HashSet;

public class CloneLLWithRandomAndNext {
    public Node copyRandomList(Node head) {
        //Using Hashing
        /*
        if(head == null) return head;
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        Node newHead = null;
        Node newTail = null;
        while(temp!=null){
            Node newNode = new Node(temp.data);
            map.put(temp,newNode);
            if(newHead == null) {
                newHead = newNode;
                newTail = newHead;
            }else{
                newTail.next = newNode;
                newTail = newTail.next;
            }
            temp = temp.next;
        }
        temp = head;
        Node temp2 = newHead;
        while (temp.next != null){
            temp2.random = map.get(temp.random);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return newHead;

         */
        //Optimised
        //Step1: Create Nodes and connect them in-between the given LL
        Node temp = head;
        while (temp!=null){
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        //Step2: Connect the random pointers according to the original
        temp = head;
        while(temp!=null){
            if(temp.random == null)temp.next.random = null;
            else temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        //Step3: Disconnect the cloned nodes from original, connect them individually and return
        Node newHead = null;
        Node newTail = null;
        temp = head;
        while (temp!=null){
            if(newHead == null){
                newHead = temp.next;
                newTail = newHead;
            }else{
                newTail.next = temp.next;
                newTail = newTail.next;
            }
            temp.next = temp.next.next;
            newTail.next = null;
            temp = temp.next;
        }
        return newHead;
    }
}
