/**
 * @author Harry Liu
 * @version Mar 2, 2020
 * @challenge https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * @solution Keep fixed distance between two pointers.
 */
public class RemoveNodeEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode target = head;
        ListNode end = createGap(target, n);

        ListNode prev = dummyHead;
        while (end != null) {
            end = end.next;
            prev = target;
            target = target.next;

        }
        prev.next = prev.next.next;
        return dummyHead.next;
    }

    private ListNode createGap(ListNode curr, int gapSize) {
        for (int i = 0; i < gapSize; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
