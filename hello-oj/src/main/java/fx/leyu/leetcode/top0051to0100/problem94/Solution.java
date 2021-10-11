package fx.leyu.leetcode.top0051to0100.problem94;

import fx.leyu.leetcode.datastructure.TreeNode;

import java.util.*;

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

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (Objects.isNull(root)) {
            return result;
        }

        // stack 存储非空元素
        Deque<TreeNode> stack = new LinkedList<>();
        addStackLeftNode(stack, root);
        while (!stack.isEmpty()) {
            TreeNode visit = stack.pollFirst();
            result.add(visit.val);
            addStackLeftNode(stack, visit.right);
        }
        return result;
    }

    private void addStackLeftNode(Deque<TreeNode> stack, TreeNode root) {
        while (Objects.nonNull(root)) {
            stack.addFirst(root);
            root = root.left;
        }
    }
}
