package LL;

import java.util.Arrays;

public class CreateLLFromArr {
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
        return;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,7,6,2,5,1,2,4};
        System.out.println(Arrays.toString(arr));
        printLL(createLL(arr));
    }
}
