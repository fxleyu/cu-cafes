package fx.leyu.leetcode.top0001to0050.problem24;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = new Solution().swapPairs(head);

        ListNode result = new ListNode(2);
        result.next = new ListNode(1);
        result.next.next = new ListNode(4);
        result.next.next.next = new ListNode(3);

        Assert.assertTrue(result.equals(head));

    }
}
