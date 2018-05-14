//判断树B是否是树A的一部分
public class HasSubtree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    private static boolean IsSubTree1(TreeNode node1, TreeNode node2){
        boolean result=false;
        if (node1!=null&&node2!=null)
        {
            if (node1.val==node2.val)
                result=IsSubTree2(node1,node2);
            if (!result)
                result=IsSubTree1(node1.left,node2);
            if (!result)
                result=IsSubTree1(node1.right,node2);
        }
        return result;
    }
    private static boolean IsSubTree2(TreeNode node1, TreeNode node2)
    {
        if (node2==null)
            return true;
        if (node1==null)
            return false;
        if (node1.val!=node2.val)
            return false;
        return IsSubTree2(node1.left,node2.left)&&IsSubTree2(node1.right,node2.right);
    }
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return IsSubTree1(root1,root2);
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(8);
        tree1.left = new TreeNode(8);
        tree1.right = new TreeNode(7);
        tree1.left.left = new TreeNode(9);
        tree1.left.right = new TreeNode(2);
        tree1.left.right.left = new TreeNode(4);
        tree1.left.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode(8);
        tree2.left = new TreeNode(9);
        tree2.right = new TreeNode(2);


        System.out.println(HasSubtree(null, null));
        System.out.println(HasSubtree(tree1, null));
        System.out.println(HasSubtree(null, tree2));
        System.out.println(HasSubtree(tree1, tree2));
    }
}
