package fx.leyu.leetcode.top0051to0100.problem94;

import fx.leyu.leetcode.datastructure.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void test() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        List<Integer> result = solution.inorderTraversal1(p);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
