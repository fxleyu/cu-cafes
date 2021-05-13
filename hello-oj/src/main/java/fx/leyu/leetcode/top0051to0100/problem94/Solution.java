package fx.leyu.leetcode.top0051to0100.problem94;

import fx.leyu.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author fxleyu
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
