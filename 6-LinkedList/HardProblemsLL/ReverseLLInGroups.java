package HardProblemsLL;

public class ReverseLLInGroups {
    public static Node createLL(int[] arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ->");
            temp = temp.next;
        }
        System.out.print("null");
        return;
    }
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
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node previousTail = null;
        Node nextNode = null;

        while (temp!= null ){
            Node nthNode = temp;
            for (int i = 1; i < k; i++) {
                nthNode = nthNode.next;
                if (nthNode == null) {
                    if(previousTail!=null) previousTail.next = nextNode;
                    return head;
                }
            }
            nextNode = nthNode.next;
            nthNode.next = null;
            Node reversedLL = reverseList(temp);
            if (temp == head) head = reversedLL;
            else previousTail.next = nthNode;
            previousTail = temp;
            temp = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        Node LL = createLL(arr);
        printLL(reverseKGroup(LL,3));
    }
}
