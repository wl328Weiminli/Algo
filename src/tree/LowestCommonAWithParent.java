package tree;

class TreeNodeP {
    int key;
    TreeNodeP left;
    TreeNodeP right;
    TreeNodeP parent;

    public TreeNodeP(int key) {
        this.key = key;
    }
}

public class LowestCommonAWithParent {
    static class RootAndHeight {
        TreeNodeP root;
        int depth;

        RootAndHeight(TreeNodeP root, int height) {
            this.root = root;
            this.depth = height;
        }
    }

    public TreeNodeP findLCA(TreeNodeP one, TreeNodeP two) {
        if (one == null || two == null) {
            return null;
        }
        RootAndHeight oneRes = countRootAndHeight(one);
        RootAndHeight twoRes = countRootAndHeight(two);
        if (oneRes.root == twoRes.root) {
            if (oneRes.depth > twoRes.depth) {
                int dif = oneRes.depth - twoRes.depth;
                while (dif > 0) {
                    one = one.parent;
                    dif--;
                }
            } else {
                int dif = twoRes.depth - oneRes.depth;
                while (dif > 0) {
                    two = two.parent;
                    dif--;
                }
            }

            while (one != two) {
                one = one.parent;
                two = two.parent;
            }
            return one;
        }
        return null;
    }

    private RootAndHeight countRootAndHeight(TreeNodeP node) {
        int depth = 1;
        while (node.parent != null) {
            node = node.parent;
            depth++;
        }
       return new  RootAndHeight(node, depth);
    }
}
