package MediumProblemsLL;

public class DetectACycle {
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        do{
            if(fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }while(slow!=fast);
        return true;
    }
}
