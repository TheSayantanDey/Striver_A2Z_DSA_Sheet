package MediumProblemsLL;

public class Add1ToLL {
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
    public static Node addOne(Node head) {
        Node reversedHead = reverseList(head);
        reversedHead.data = reversedHead.data +1;
        boolean extra = false;
        Node temp = reversedHead;
        while (temp!=null && temp.data == 10){
            temp.data = 0;
            if(temp.next != null) temp.next.data = temp.next.data+1;
            else temp.next = new Node(1);
            temp = temp.next;
        }
        return reverseList(reversedHead);
    }
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
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {9,9,9};
        printLL(addOne(createLL(arr)));
    }
}
