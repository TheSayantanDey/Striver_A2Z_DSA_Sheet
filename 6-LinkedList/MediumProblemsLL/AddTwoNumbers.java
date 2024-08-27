package MediumProblemsLL;

public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node head = null;
        Node tail = null;
        int carry = 0;
        while (l1!=null || l2!=null){
            int val1 = 0;
            if(l1 !=null){
                val1 = l1.data;
                l1 = l1.next;
            }
            int val2 = 0;
            if(l2 != null){
                val2 = l2.data;
                l2 = l2.next;
            }
            int sum = val1+val2+carry;
            carry = sum/10;
            sum = sum%10;
            Node newNode = new Node(sum);

            if(head==null){
                head = newNode;
                tail = head;
            }else{
                tail.next = newNode;
                tail = tail.next;
            }
        }
        if(carry == 1) tail.next = new Node(1);
        return head;
    }
}
