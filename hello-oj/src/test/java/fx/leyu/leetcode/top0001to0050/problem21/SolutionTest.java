package fx.leyu.leetcode.top0001to0050.problem21;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        ListNode aNode1 = new ListNode(1);
        ListNode aNode2 = new ListNode(6);
        ListNode aNode3 = new ListNode(10);
        ListNode bNode1 = new ListNode(1);
        ListNode bNode2 = new ListNode(3);
        ListNode bNode3 = new ListNode(4);
        aNode1.next = aNode2;
        aNode2.next = aNode3;
        bNode1.next = bNode2;
        bNode2.next = bNode3;
        bNode3.next = new ListNode(10);

        ListNode result = new Solution().mergeTwoLists(aNode1, bNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
