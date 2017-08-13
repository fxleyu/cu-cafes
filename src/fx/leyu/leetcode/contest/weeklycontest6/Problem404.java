package fx.leyu.leetcode.contest.weeklycontest6;

import java.util.LinkedList;
import java.util.Queue;

public class Problem404 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        
        Queue<TreeNode> workQueue = new LinkedList<>();
        workQueue.add(root);
        while (!workQueue.isEmpty()) {
            TreeNode now = workQueue.poll();
            if (now == null) {
                continue;
            }
            
            workQueue.add(now.left);
            workQueue.add(now.right);
            
            if (isLeave(now.left)) {
                result += now.left.val;
            }
        }
        return result;
    }

    private boolean isLeave(TreeNode left) {
        if (left != null && left.right == null && left.left == null) {
            return true;
        }
        return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
