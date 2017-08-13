package fx.leyu.leetcode.problem.problem21;

import fx.leyu.leetcode.problem.problem02.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        
        ListNode l2 = new ListNode(3);
        ListNode result = new Solution().mergeTwoLists(l1, l2);
        System.out.println(result.toString());
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }
    
    // ME-TEST
    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode header = result;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val){
                result.next = l2;
                l2 = l2.next;
            } else {
                result.next = l1;
                l1 = l1.next;
            }
            result = result.next;
        }
        result.next = (l1 == null) ? l2 : l1;
        
        return header.next;
    }
    */
}
