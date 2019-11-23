package fx.leyu.leetcode.top0101to0150.problem101;

/**
 * @author fxleyu
 */

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * <p>
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Optional<TreeNode> left = Optional.ofNullable(root).map(x -> x.left);
        Optional<TreeNode> right = Optional.ofNullable(root).map(x -> x.right);
        return isSymmetric(left, right);
    }

    private boolean isSymmetric(Optional<TreeNode> left, Optional<TreeNode> right) {
        // 左右子树均为 null
        if (Objects.isNull(left.orElse(null)) && Objects.isNull(right.orElse(null))) {
            return true;
        }

        Function<TreeNode, Integer> function = treeNode -> treeNode.val;
        // 左右子树的root值不相等
        if (!Objects.equals(left.map(function).orElse(null), right.map(function).orElse(null))) {
            return false;
        }

        Function<TreeNode, TreeNode> rightMapper = treeNode -> treeNode.right;
        Function<TreeNode, TreeNode> leftMapper = treeNode -> treeNode.left;
        return isSymmetric(left.map(rightMapper), right.map(leftMapper))
                && isSymmetric(left.map(leftMapper), right.map(rightMapper));
    }
}