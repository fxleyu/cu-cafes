package fx.leyu.leetcode.top0001to0050.problem24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;

        for (ListNode first = result; head != null && head.next != null; first = head, head = head.next) {
            first.next = head.next;
            head.next = first.next.next;
            first.next.next = head;
        }

        return result.next;
    }
}
