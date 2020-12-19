package recursionII;

public class ReverseLinkedListByPair {
    static class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
        }
    }
    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverseInPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = temp;
        return newHead;
    }

}
