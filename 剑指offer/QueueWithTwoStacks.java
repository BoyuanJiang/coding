import java.util.Stack;

//    使用两个栈模仿队列
public class QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.push(1);
        queueWithTwoStacks.push(2);
        queueWithTwoStacks.push(3);
        System.out.println(queueWithTwoStacks.pop());
        queueWithTwoStacks.push(4);
        System.out.println(queueWithTwoStacks.pop());
        System.out.println(queueWithTwoStacks.pop());
        System.out.println(queueWithTwoStacks.pop());


    }
}
