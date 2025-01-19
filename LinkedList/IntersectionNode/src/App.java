class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class App {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            lengthA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            lengthB++;
        }
        tempA = headA;
        tempB = headB;
        while (lengthA < lengthB) {
            lengthB--;
            tempB = tempB.next;
        }
        while (lengthB < lengthA) {
            lengthA--;
            tempA = tempA.next;
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}
