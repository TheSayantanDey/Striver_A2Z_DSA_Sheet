package MediumProblemsLL;

public class StartingPointOfALoop {
    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        boolean cycleFlag = false;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycleFlag = true;
                break;
            }
        }
        if(!cycleFlag) return null;
        Node slow2 = head;
        while (slow != slow2){
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}
