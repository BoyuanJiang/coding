public class IsBalanced_Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean IsBalanced_Solution0(TreeNode root) {
        //需要多次遍历二叉树
        if (root==null)
            return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left-right;
        if (diff>1||diff<-1)
            return false;
        return IsBalanced_Solution0(root.right)&&IsBalanced_Solution0(root.left);
    }

    private int TreeDepth(TreeNode root) {
        //从下往上统计深度
        if (root==null)
            return 0;
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);
        return nLeft>nRight?nLeft+1:nRight+1;
    }


    private boolean isbalance=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        //后序遍历时直接判断，只需要遍历节点一次
        getDepth(root);
        return isbalance;
    }
    private int getDepth(TreeNode root)
    {
        if (root==null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left-right>1||left-right<-1)
            isbalance=false;
        return left>right?left+1:right+1;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        IsBalanced_Solution sol = new IsBalanced_Solution();
    }
}
