import java.util.Stack;

public class ConstructBinaryTree {
//    剑指offer:006
//    输入前序 {1,2,4,7,3,5,6,8}和中序{4,7,2,1,5,3,8,6},重建出该二叉树
//    后序遍历{7,4,2,5,8,6,3,1}

    private  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    public static void main(String[] args) {
        // write your code here
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new ConstructBinaryTree().reConstructBinaryTree(pre,in);
        printtree13(root);
//        System.out.println(root.toString());
    }



    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length!=in.length)
            return null;
        TreeNode root = reConstructBinaryTree(pre, 0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn)
    {
        if (startPre>endPre || startIn>endIn)
        {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i=startIn;i<=endIn;i++)
        {
            if (in[i]==pre[startPre])
            {
                root.left = reConstructBinaryTree(pre, startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
                break;
            }
        }
        return root;
    }



    public static void printtree11(TreeNode root)
    {
//        前序遍历 第归
        if (root!=null)
        {
            System.out.println(root.val);
            if (root.left!=null)
                printtree11(root.left);
            if (root.right!=null)
                printtree11(root.right);
        }
    }

    public static void printtree12(TreeNode root)
    {
//        中序遍历 第归
        if (root!=null)
        {

            if (root.left!=null)
                printtree12(root.left);
            System.out.println(root.val);
            if (root.right!=null)
                printtree12(root.right);
        }
    }

    public static void printtree13(TreeNode root)
    {
//        后序遍历 第归
        if (root!=null)
        {

            if (root.left!=null)
                printtree13(root.left);

            if (root.right!=null)
                printtree13(root.right);
            System.out.println(root.val);
        }
    }

    public static void printtree21(TreeNode root)
    {
//        前序遍历 循环
        Stack<TreeNode> st = new Stack<>();
        while (root!=null||!st.isEmpty())
        {
            System.out.println(root.val);
            st.push(root);
            root = root.left;
            while (root==null&&!st.isEmpty())
            {
                root=st.pop();
                root=root.right;
            }
        }
    }
    public static void printtree22(TreeNode root)
    {
//        中序遍历 循环
        Stack<TreeNode> st = new Stack<>();
        while (root!=null||!st.isEmpty())
        {
            st.push(root);
            root=root.left;
            while (root==null&&!st.isEmpty())
            {
                root=st.pop();
                System.out.println(root.val);
                root=root.right;
            }
        }
    }
    public static void printtree23(TreeNode root)
    {
//        后续遍历 循环
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr=null;
        TreeNode prev=null;
        st.push(root);
        while (!st.isEmpty())
        {
            curr=st.peek();
            if (prev==null||prev.left==curr||prev.right==curr)
            {
//                当前访问的是根结点
                if (curr.left!=null)
                    st.push(curr.left);
                else if (curr.right!=null)
                    st.push(curr.right);
            }
            else if (curr.left==prev)
            {
//                如果当前节点的左边刚刚访问过了,那么应该访问当前节点的右边
                if (curr.right!=null)
                    st.push(curr.right);
            }
            else {
//                之前访问的节点是当前的右儿子,或者当前的节点位于最下面了,直接输出
                System.out.println(curr.val);
                st.pop();
            }
            prev=curr;
        }
    }
}