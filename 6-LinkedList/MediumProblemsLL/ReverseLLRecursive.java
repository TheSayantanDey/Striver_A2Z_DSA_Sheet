package MediumProblemsLL;

public class ReverseLLRecursive {
    public Node reverseList(Node head) {
        //Base case
        if(head == null || head.next == null) return head;

        //Recursive call
        Node newHead = reverseList(head.next);

        //Calculations
        Node tail = head.next; // head still contains the reference to the node which is now the last node
        head.next = null;
        tail.next = head;

        return newHead;
    }
}
