import java.util.Stack;

public class TreeDepth {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    private int maxDepth=0;
    public int TreeDepth0(TreeNode root) {
        //一个直接的思想是直接遍历整个二叉树，记录最深的值,需要使用一个辅助的栈
        if (root==null)
            return maxDepth;
        Stack<TreeNode> st = new Stack<>();
        Find(root,st);
        return maxDepth;
    }

    private void Find(TreeNode root, Stack<TreeNode> st)
    {
        st.add(root);
        if (root.left==null&&root.right==null)
        {
            maxDepth=st.size()>maxDepth?st.size():maxDepth;
        }
        else {
            if (root.left!=null) Find(root.left,st);
            if (root.right!=null) Find(root.right,st);
        }
        st.pop();
    }

    public int TreeDepth(TreeNode root) {
        //从下往上统计深度
        if (root==null)
            return 0;
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);
        return nLeft>nRight?nLeft+1:nRight+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        TreeDepth sol = new TreeDepth();
        System.out.println(sol.TreeDepth(root));
    }
}
