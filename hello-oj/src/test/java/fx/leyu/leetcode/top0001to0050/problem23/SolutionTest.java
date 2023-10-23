package fx.leyu.leetcode.top0001to0050.problem23;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        ListNode[] input = new ListNode[3];
        input[0] = new ListNode(1);
        input[0].next = new ListNode(4);
        input[0].next.next = new ListNode(5);
        input[1] = new ListNode(1);
        input[1].next = new ListNode(3);
        input[1].next.next = new ListNode(4);
        input[2] = new ListNode(2);
        input[2].next = new ListNode(6);

        ListNode result = new ListNode(1);
        result.next = new ListNode(1);
        result.next.next = new ListNode(2);
        result.next.next.next = new ListNode(3);
        result.next.next.next.next = new ListNode(4);
        result.next.next.next.next.next = new ListNode(4);
        result.next.next.next.next.next.next = new ListNode(5);
        result.next.next.next.next.next.next.next = new ListNode(6);
        Assert.assertEquals(result, new Solution().mergeKLists(input));

    }

    @Test
    public void testErrorCase1() {
        ListNode[] input = new ListNode[2];
        input[0] = null;
        input[1] = new ListNode(1);

        ListNode result = new ListNode(1);
        Assert.assertEquals(result, new Solution().mergeKLists(input));
    }

    @Test
    public void testErrorCase2() {
        ListNode[] input = new ListNode[6];
        input[0] = new ListNode(-9);
        input[0].next = new ListNode(-7);
        input[0].next.next = new ListNode(-7);
        input[1] = new ListNode(-6);
        input[1].next = new ListNode(-4);
        input[1].next.next = new ListNode(-1);
        input[1].next.next.next = new ListNode(1);
        input[2].next = new ListNode(6);

        ListNode result = new ListNode(1);
        result.next = new ListNode(1);
        result.next.next = new ListNode(2);
        result.next.next.next = new ListNode(3);
        result.next.next.next.next = new ListNode(4);
        result.next.next.next.next.next = new ListNode(4);
        result.next.next.next.next.next.next = new ListNode(5);
        result.next.next.next.next.next.next.next = new ListNode(6);
        Assert.assertEquals(result, new Solution().mergeKLists(input));
    }
}
