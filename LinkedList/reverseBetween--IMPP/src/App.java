class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class App {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode after = start.next;
        for (int i = 0; i < right - left; i++) {
            start.next = after.next;
            after.next = prev.next;
            prev.next = after;
            after = start.next;
        }
        return dummy.next;
    }
}
