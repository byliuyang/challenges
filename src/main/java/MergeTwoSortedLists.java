/**
 * @author Harry Liu
 * @version Mar 2, 2020
 * @challenge https://leetcode.com/problems/merge-two-sorted-lists
 * @solution Similar as Merge Sort. Use dummy head to simplify edge cases.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode end = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }

        if (l1 == null) {
            end.next = l2;
        }

        if (l2 == null) {
            end.next = l1;
        }

        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
