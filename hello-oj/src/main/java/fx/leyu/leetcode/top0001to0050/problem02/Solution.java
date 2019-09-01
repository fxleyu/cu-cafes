package fx.leyu.leetcode.top0001to0050.problem02;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        a.next = l1;
        b.next = l2;

        ListNode result = new ListNode(0);
        ListNode index = result;
        int carry = 0;
        while (a.next != null || b.next != null) {
            int value = carry;
            if (a.next != null && b.next != null) {
                value += a.next.val + b.next.val;
            } else {
               value += a.next == null ? b.next.val : a.next.val;
            }
            carry = value / 10;
            index.next = new ListNode(value % 10);

            a = a.next == null ? a : a.next;
            b = b.next == null ? b : b.next;
            index = index.next;
        }
        if (carry != 0) {
            index.next = new ListNode(carry);
        }

        return result.next;
    }
}
