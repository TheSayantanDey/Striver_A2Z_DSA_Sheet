package MediumProblemsLL;


public class MiddleOfTheLL {
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next != null){
            if(fast.next.next == null) return slow.next;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
