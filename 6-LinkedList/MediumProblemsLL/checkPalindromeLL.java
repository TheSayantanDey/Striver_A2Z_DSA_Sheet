package MediumProblemsLL;

public class checkPalindromeLL {
    public static Node reverseList(Node head) {
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
    public static boolean isPalindrome(Node head) {
        //Using Stack
        /*
        if(head == null) return true;
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (!stack.isEmpty()){
            if(temp.data != stack.pop()) return false;
            temp = temp.next;
        }
        return true;
         */

        Node slow = head;
        Node fast = head;
        while(true){
            if(fast.next == null || fast.next.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        Node lastHalfReversed = reverseList(slow);


        Node first = head;
        Node second = lastHalfReversed;
        while(second!=null){
            if(first.data != second.data) {
                reverseList(lastHalfReversed); //Returning the LL to its original form
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(lastHalfReversed); //Returning the LL to its original form
        return true;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        System.out.println(isPalindrome(a));
    }
}
