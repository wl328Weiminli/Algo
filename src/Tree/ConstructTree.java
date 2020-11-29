package Tree;

public class ConstructTree {
    public TreeNode levelOrderConstruct(Integer[] array) {
        // Base case for recursion
        if (array == null || array.length == 0) {
            return null;
        }
        return construct(array, 0);
    }

    private TreeNode construct(Integer[] array, int index) {
        if (index < array.length) {
            if (array[index] == null) {
                return null;
            }
            TreeNode newNode = new TreeNode(array[index]);
            newNode.left = construct(array, 2 * index + 1);
            newNode.right = construct(array, 2 * index + 2);
            return newNode;
        }
        return null;
    }



}
// 0 1 2 3 4  5
//       0
//     /   \
//     1      2
//   /   \   /
//  3    4  5