package fx.leyu.leetcode.top1to50.problem02;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode tempA = a;
        tempA.next = new ListNode(2);
        tempA = tempA.next;
        //tempA.next = new ListNode(4);
        //tempA = tempA.next;
        //tempA.next = new ListNode(3);

        ListNode tempB = b;
        tempB.next = new ListNode(5);
        tempB = tempB.next;
        tempB.next = new ListNode(6);
        tempB = tempB.next;
        tempB.next = new ListNode(9);

        ListNode result = new Solution().addTwoNumbers(a.next, b.next);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println();
    }
}
