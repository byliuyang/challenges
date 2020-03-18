/**
 * @author Harry Liu
 * @version Mar 17, 2020
 * @challenge https://leetcode.com/problems/swap-nodes-in-pairs
 * @solution Swap a group of 2 nodes at a time.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);

        ListNode parent = dummyHead;
        ListNode left = head;
        ListNode right = head.next;

        while (left != null && right != null) {
            swap(parent, left, right);

            parent = left;
            left = left.next;
            if (left == null) {
                continue;
            }
            right = left.next;
        }

        return dummyHead.next;
    }

    private void swap(ListNode parent, ListNode left, ListNode right) {
        left.next = right.next;
        right.next = left;
        parent.next = right;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
