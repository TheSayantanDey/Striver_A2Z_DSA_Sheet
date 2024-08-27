package MediumProblemsLL;

public class FindIntersection {
    public int lengthDiff(Node headA, Node headB){
        int len1 = 0;
        while (headA != null){
            len1++;
            headA = headA.next;
        }
        int len2 = 0;
        while (headB != null){
            len2++;
            headB = headB.next;
        }
        return len1-len2;
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        //Brute
        /*
        Node pointerA = headA;
        while (pointerA != null){
            Node pointerB = headB;
            while (pointerB != null){
                if(pointerA == pointerB) return pointerA;
                pointerB = pointerB.next;
            }
            pointerA = pointerA.next;
        }
        return null;
         */

        //Better - hashing
        /*
        HashSet<Node> set = new HashSet<>();
        Node pointerA = headA;
        while (pointerA !=null){
            set.add(pointerA);
            pointerA = pointerA.next;
        }
        Node pointerB = headB;
        while (pointerB != null){
            if(set.contains(pointerB)) return pointerB;
            pointerB = pointerB.next;
        }
        return null;

         */

        //Optimal - using length diff
        /*
        int diff = lengthDiff(headA, headB);
        if(diff<0){
            while (diff<0){
                diff++;
                headB = headB.next;
            }
        }else {
            while (diff>0){
                diff--;
                headA = headA.next;
            }
        }

        while (headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
         */

        //Optimal - Optimising previous one
        Node pointerA = headA;
        Node pointerB = headB;
        while (pointerA != pointerB){
            pointerA = pointerA.next;
            pointerB = pointerB.next;

            if(pointerA == pointerB) return pointerB;

            if(pointerA == null) pointerA = headB;
            if(pointerB == null) pointerB = headA;
        }
        return pointerA;
    }
}
