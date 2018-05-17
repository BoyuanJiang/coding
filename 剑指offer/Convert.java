import java.util.Stack;

public class Convert {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;

        boolean isFirst=true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode P = pRootOfTree;
        TreeNode pre = null;
        while (P!=null||!st.isEmpty())
        {
            while (P!=null)
            {
                st.push(P);
                P= P.left;
            }
            P=st.pop();
            if (isFirst)
            {
                pRootOfTree=P;
                pre=pRootOfTree;
                isFirst=false;
            }
            else {
                P.left=pre;
                pre.right=P;
                pre=P;
            }
            P=P.right;
        }
        return pRootOfTree;
    }
}
