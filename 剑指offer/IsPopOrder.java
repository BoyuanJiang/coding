import java.util.Stack;

public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length!=popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int idx=0;
        for (int i=0;i<pushA.length;i++)
        {
            stack.push(pushA[i]);
            while (idx<popA.length&&stack.peek()==popA[idx])
            {
                stack.pop();
                idx++;
            }
        }
        if (idx==popA.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,2};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
