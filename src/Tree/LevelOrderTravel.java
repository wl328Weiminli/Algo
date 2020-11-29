package Tree;

import java.util.*;

public class LevelOrderTravel {
    public void levelOrderTravel(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sb.append(String.valueOf(cur.key) + ' ');
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            System.out.println(sb.toString());
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key);
        inorder(root.right);
    }

    public static void main(String[] args) {
        LevelOrderTravel test = new LevelOrderTravel();
        ConstructTree cons = new ConstructTree();
        Integer[] arr = {6, 5, 4, null, 6, 1, 7, null, null, 10, null, null, null, null, null, null, null, null, null, null, null, null};
        TreeNode root = cons.levelOrderConstruct(arr);
        test.levelOrderTravel(root);
    }
}
