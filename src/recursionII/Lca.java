package recursionII;

public class Lca {
    static class TreeNode{
        int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, a, b);
        TreeNode rightNode = lowestCommonAncestor(root.right, a, b);


        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }
    // if a and b  may not in the tree
    public TreeNode check(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode temp = lowestCommonAncestor(root, a, b);
        if(temp == a)  {
            if (lowestCommonAncestor(a, b, b) != b) {
                return null;
            }
        }else if (temp == b) {
            if (lowestCommonAncestor(b, a, a) != a) {
                return null;
            }
        }
        return temp;

    }

}
