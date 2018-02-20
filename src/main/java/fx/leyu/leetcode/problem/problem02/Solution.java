package fx.leyu.leetcode.problem.problem02;

/*
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {
    
    private int overflow = 0;

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(0);
        
        System.out.println(new Solution().addTwoNumbers(c, d).toString());
        System.out.println(new Solution().addTwoNumbers(a, b).toString());
        System.out.println(new Solution().addTwoNumbers(a, d).toString());
        System.out.println(new Solution().addTwoNumbers(d, a).toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null || l2==null) {
            return l1==null ? l2 : l1;
        }
        
        int temp = l1.val + l2.val;
        overflow = temp>9 ? 1 : 0; 
        ListNode result = new ListNode(overflow>0 ? temp-10 : temp);
        
        ListNode indexA = l1.next;
        ListNode indexB = l2.next;
        ListNode index = result;
        while (indexA!=null && indexB!=null) {
            temp = indexA.val + indexB.val + overflow;
            overflow = temp>9 ? 1 : 0; 
            index.next = new ListNode(overflow>0 ? temp-10 : temp);
            
            index = index.next;
            indexA = indexA.next;
            indexB = indexB.next;
        }
        
        if (indexA!=null || indexB!=null) {
            if (indexA!=null) {
                index = append(indexA, index);
            } else {
                index = append(indexB, index);
            }
        }
        
        if(overflow > 0) {
            index.next = new ListNode(overflow);
        }
        
        return result;
    }

    private ListNode append(ListNode indexA, ListNode index) {
        while (indexA!=null) {
            int temp = indexA.val + overflow;
            overflow = temp>9 ? 1 : 0; 
            index.next = new ListNode(overflow>0 ? temp-10 : temp);
            
            index = index.next;
            indexA = indexA.next;
        }
        return index;
    }
}
