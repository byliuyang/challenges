import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Harry Liu
 * @version Mar 17, 2020
 * @challenge https://leetcode.com/problems/merge-k-sorted-lists
 * @solution Keep at most k elements in the priority queue at any time.
 */
public class MergeKSortedLists {
    private static final SortByValOrder sortByValOrder = new SortByValOrder();

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        int numLists = lists.length;
        if (numLists < 1) {
            return null;
        }

        if (numLists == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(numLists, sortByValOrder);

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode end = dummyHead;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            end.next = curr;
            end = curr;

            if (curr.next == null) {
                continue;
            }
            pq.add(curr.next);
        }

        return dummyHead.next;
    }

    private static class SortByValOrder implements Comparator<ListNode> {
        public int compare(ListNode list1, ListNode list2) {
            return list1.val - list2.val;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
