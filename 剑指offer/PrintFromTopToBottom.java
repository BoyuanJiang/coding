import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null)
            return res;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            root=queue.poll();
            res.add(root.val);
            if (root.left!=null)
                queue.offer(root.left);
            if (root.right!=null)
                queue.offer(root.right);
        }
        return res;
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        System.out.println(PrintFromTopToBottom(root));
    }
    }
