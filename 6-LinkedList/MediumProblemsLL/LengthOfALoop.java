package MediumProblemsLL;

public class LengthOfALoop {
    public int findLengthOfLoop(Node slow, Node fast){
        slow = slow.next;
        int length = 1;
        while (slow!=fast){
            slow = slow.next;
            length++;
        }
        return length;
    }
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int length = 0;
        boolean firstMeet = false;
        while(fast != null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;
             if(slow == fast){
                 return findLengthOfLoop(slow,fast);
             }
        }
        return 0;

    }
}
