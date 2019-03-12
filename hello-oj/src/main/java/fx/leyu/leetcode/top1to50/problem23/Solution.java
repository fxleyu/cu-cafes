package fx.leyu.leetcode.top1to50.problem23;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        createSmallTopHeap(lists);

        ListNode head = new ListNode(-1);
        ListNode index = head;
        while(lists[0] != null) {
            index.next = lists[0];
            index = index.next;
            lists[0] = index.next;
            adjustSmallTopHeap(lists);
        }
        return head.next;
    }

    private void adjustSmallTopHeap(ListNode[] lists) {
        if (lists[0] == null) {
            for (int i = lists.length - 1; i >= 0; i--) {
                if (lists[i] != null) {
                    exchange(lists, 0, i);
                }
            }
        }
        if (lists[0] == null) {
            return;
        }

        for (int top = 0, smallIndex = smallIndex(lists, top);
             top != smallIndex;
             top = smallIndex, smallIndex = smallIndex(lists, top)) {
            exchange(lists, top, smallIndex);
        }
    }

    private int smallIndex(ListNode[] lists, int top) {
        int left = top * 2 + 1;
        int right = top * 2 + 2;
        int result = top;
        if (left < lists.length && lists[left] != null) {
            result = lists[left].val > lists[result].val ? result : left;
        }
        if (right < lists.length && lists[right] != null) {
            result = lists[right].val > lists[result].val ? result : right;
        }
        return result;
    }

    private void createSmallTopHeap(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                break;
            }
            for(int next = i, top = (next - 1) / 2;
                top >= 0 && lists[top].val > lists[next].val;
                next = top, top = (next - 1) / 2) {
                exchange(lists, top, next);
            }
        }
    }

    private void exchange(ListNode[] lists, int top, int next) {
        ListNode temp = lists[top];
        lists[top] = lists[next];
        lists[next] = temp;
    }
}
