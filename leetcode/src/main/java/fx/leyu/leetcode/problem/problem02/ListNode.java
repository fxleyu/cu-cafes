package fx.leyu.leetcode.problem.problem02;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    
    @Override
    public String toString() {
        ListNode index = this;
        StringBuilder result = new StringBuilder(""+index.val);
        while(index.next!=null) {
            index = index.next;
            result.append(" -> " + index.val);
        }
        return result.toString();
    }
}
