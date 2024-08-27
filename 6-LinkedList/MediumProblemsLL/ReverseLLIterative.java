package MediumProblemsLL;

public class ReverseLLIterative {
    public Node reverseList(Node head) {
        if(head == null) return head;
        Node curr = head;
        Node nextNode = curr.next;
        head.next = null;
        while ( nextNode != null){
            Node temp = nextNode.next;
            nextNode.next = curr;

            curr = nextNode;
            nextNode = temp;
        }
        return curr;
    }
}
