package fx.leyu.leetcode.top51to100.problem83;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode result = new Solution().deleteDuplicates(head);

        while(result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }
    }
}
