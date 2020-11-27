package Tree;

public class ConstructTree {
    public TreeNode insertLevelOrder(Integer[] arr, TreeNode root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }
}
// 0 1 2 3 4  5
//       0
//     /   \
//     1      2
//   /   \   /
//  3    4  5