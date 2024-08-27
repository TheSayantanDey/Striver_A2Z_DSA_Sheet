package MediumProblemsLL;

public class DeleteTheMiddleNode {
    public Node deleteMiddle(Node head) {
        if(head == null || head.next == null) return head;
        Node fast = head;
        Node slow = head;
        Node prevNode = null;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            prevNode = slow;
            slow = slow.next;
        }
        if(fast.next != null) {
            prevNode = slow;
            slow = slow.next;
        }
        prevNode.next = slow.next;
        return head;
    }
}
