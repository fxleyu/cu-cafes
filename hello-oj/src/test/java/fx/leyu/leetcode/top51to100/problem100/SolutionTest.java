package fx.leyu.leetcode.top51to100.problem100;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        Assert.assertTrue(new Solution().isSameTree(p, q));

        p.right = null;
        q.left = null;
        q.right = new TreeNode(2);
        Assert.assertFalse(new Solution().isSameTree(p, q));
    }
}
