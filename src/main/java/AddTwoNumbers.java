/**
 * https://leetcode.com/problems/add-two-numbers
 *
 * @author Harry Liu
 * @version Sept 11th, 2019
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final int BASE = 10;

        ListNode dummyHead = new ListNode(-1);
        ListNode sumCurr = dummyHead;
        ListNode currFirst = l1;
        ListNode currSecond = l2;
        int carry = 0;

        while (currFirst != null || currSecond != null) {
            int firstDigit = 0;
            int secondDigit = 0;

            if (currFirst != null) {
                firstDigit = currFirst.val;
                currFirst = currFirst.next;
            }

            if (currSecond != null) {
                secondDigit = currSecond.val;
                currSecond = currSecond.next;
            }

            int digitSum = firstDigit + secondDigit + carry;

            carry = digitSum / BASE;
            int digit = digitSum % BASE;

            sumCurr.next = new ListNode(digit);
            sumCurr = sumCurr.next;
        }

        if (carry == 0) {
            return dummyHead.next;
        }

        sumCurr.next = new ListNode(carry);
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}