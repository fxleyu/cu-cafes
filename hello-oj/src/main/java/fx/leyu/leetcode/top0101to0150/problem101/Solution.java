package fx.leyu.leetcode.top0101to0150.problem101;

import fx.leyu.leetcode.datastructure.TreeNode;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * 镜像数判断
 *
 * @author fxleyu
 */
class Solution {
    private static final Function<TreeNode, Integer> VAL_MAPPER = treeNode -> treeNode.val;
    private static final Function<TreeNode, TreeNode> RIGHT_MAPPER = treeNode -> treeNode.right;
    private static final Function<TreeNode, TreeNode> LEFT_MAPPER = treeNode -> treeNode.left;

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(Optional.ofNullable(root).map(LEFT_MAPPER), Optional.ofNullable(root).map(RIGHT_MAPPER));
    }

    private boolean isSymmetric(Optional<TreeNode> left, Optional<TreeNode> right) {
        // 左右子树均为 null
        if (Objects.isNull(left.orElse(null)) && Objects.isNull(right.orElse(null))) {
            return true;
        }

        // 左右子树的root值不相等
        if (!Objects.equals(left.map(VAL_MAPPER).orElse(null), right.map(VAL_MAPPER).orElse(null))) {
            return false;
        }

        // 左右子树处理
        return isSymmetric(left.map(RIGHT_MAPPER), right.map(LEFT_MAPPER))
                && isSymmetric(left.map(LEFT_MAPPER), right.map(RIGHT_MAPPER));
    }
}