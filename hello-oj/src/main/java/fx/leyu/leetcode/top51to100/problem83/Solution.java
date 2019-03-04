package fx.leyu.leetcode.top51to100.problem83;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(head.val);
        ListNode index =result;
        while (head.next != null) {
            head = head.next;
            if (head.val != index.val) {
                index.next = new ListNode(head.val);
                index = index.next;
            }
        }
        return result;
    }
}
