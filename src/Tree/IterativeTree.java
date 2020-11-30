package Tree;

import java.util.*;

public class IterativeTree {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekLast();
            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.offerLast(cur.left);
                } else if (cur.right != null) {
                    stack.offerLast(cur.right);
                } else {
                    stack.pollLast();
                    res.add(cur.key);
                }
            } else if (cur.left == pre) {
                if (cur.right != null) {
                    stack.offerLast(cur.right);
                } else {
                    stack.pollLast();
                    res.add(cur.key);
                }
            } else {
                stack.pollLast();
                res.add(cur.key);
            }
            pre = cur;
        }
        return res;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;
        while (helper != null || !stack.isEmpty()) {
            if (helper != null) {
                stack.offerLast(helper);
                helper = helper.left;
            } else {
                helper = stack.pollLast();
                res.add(helper.key);
                helper = helper.right;
            }
        }
        return res;
    }


}
