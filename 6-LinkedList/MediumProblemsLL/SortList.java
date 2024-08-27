package MediumProblemsLL;

public class SortList {
    public static Node mergeTwoSortedLists(Node head, Node newHead){
        Node finalHead = null;
        Node finalHeadPointer = finalHead;
        Node headPointer = head;
        Node newHeadPointer = newHead;
        while (headPointer != null && newHeadPointer != null){
            if(headPointer.data < newHeadPointer.data){
                if(finalHeadPointer == null){
                    finalHead = headPointer;
                    finalHeadPointer = finalHead;
                }else{
                    finalHeadPointer.next = headPointer;
                    finalHeadPointer = finalHeadPointer.next;
                }
                headPointer = headPointer.next;
            }else{
                if(finalHeadPointer == null){
                    finalHead = newHeadPointer;
                    finalHeadPointer = finalHead;
                }else{
                    finalHeadPointer.next = newHeadPointer;
                    finalHeadPointer = finalHeadPointer.next;
                }
                newHeadPointer = newHeadPointer.next;
            }
        }
        if(headPointer == null){
            if(finalHeadPointer == null) finalHead = newHeadPointer;
            else finalHeadPointer.next = newHeadPointer;
        }
        else{//newHeadPointer == null
            if(finalHeadPointer == null) finalHead = headPointer;
            else finalHeadPointer.next = headPointer;
        }
        return finalHead;
    }
    public static Node sortList(Node head) {
        //We will implement a modified version of merge sort to sort the linked list
        //Base case
        if(head == null || head.next == null) return head;

        //Find the mid
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = slow.next;
        slow.next = null;
        Node head1 = sortList(head);
        Node head2 = sortList(newHead);

        return mergeTwoSortedLists(head1,head2);
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
        int[] arr = {2,5,4,3,6,0};
        Node LL = createLL(arr);
        printLL(LL);
        Node sortedLL = sortList(LL);
        printLL(sortedLL);
    }
}
