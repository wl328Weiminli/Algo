package Tree;

public class DeleteInBST {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (root.key > key) {
            root.left = deleteTree(root.left, key);
            return root;
        }else if (root.key < key) {
            root.right = deleteTree(root.right, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }else if (root.left == null) {
            return root.right;
        }else if (root.right == null){
            return root.left;
        }

        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        TreeNode newNode = findPlaces(root.right);
        newNode.left = root.left;
        newNode.right = root.right;
        return newNode;
    }

    private TreeNode findPlaces(TreeNode root) {
        TreeNode cur = root.left;
        while (cur.left != null) {
            cur = cur.left;
            root = root.left;
        }

        root.left = cur.right;
        return  cur;
    }

}
