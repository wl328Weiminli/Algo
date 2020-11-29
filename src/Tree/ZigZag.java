package Tree;

import java.util.*;

public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean flag = true;
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> aLevel = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode temp = deque.pollLast();
                    aLevel.add(temp.key);
                    if (temp.left != null) {
                        deque.offerFirst(temp.left);
                    }
                    if (temp.right != null) {
                        deque.offerFirst(temp.right);
                    }
                }else {
                    TreeNode temp = deque.pollFirst();
                    aLevel.add(temp.key);
                    if (temp.right != null) {
                        deque.offerLast(temp.right);
                    }
                    if (temp.left != null) {
                        deque.offerLast(temp.left);
                    }
                }
            }
            flag = !flag;
            res.add(aLevel);
        }
        return res;
    }

}
