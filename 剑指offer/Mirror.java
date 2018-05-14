public class Mirror {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
        public String toString() {
            if(left != null && right != null) {
                return "[" + left + "," + val + "," + right + "]";
            } else if(left != null) {
                return "[" + left + "," + val + ",#,]";
            } else if(right != null) {
                return "[#," + val + "," + right + "]";
            } else {
                return "" + val;
            }
        }
    }
    public static void Mirror(TreeNode root) {
        if (root==null)
            return;
        if (root.left==null&&root.right==null)
            return;
        TreeNode tmp = null;

        tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        if (root.left!=null)
            Mirror(root.left);
        if (root.right!=null)
            Mirror(root.right);

    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(8);
        tree1.right = new TreeNode(7);
        tree1.left.left = new TreeNode(9);
        tree1.left.right = new TreeNode(2);
        tree1.left.right.left = new TreeNode(4);
        tree1.left.right.right = new TreeNode(7);

        Mirror(tree1);
        System.out.println(tree1.toString());

    }
}
