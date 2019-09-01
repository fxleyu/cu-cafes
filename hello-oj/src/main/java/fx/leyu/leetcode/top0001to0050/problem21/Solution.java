package fx.leyu.leetcode.top0001to0050.problem21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode result = new ListNode(0);
        ListNode now = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                now.next = l2;
                l2 = l2.next;
            } else {
                now.next = l1;
                l1 = l1.next;
            }
            now = now.next;
        }

        now.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
